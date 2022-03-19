package shane.leetcode.problems.xhard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Time: 839 ms (5.01%), Space: 73 MB (28.71%)
 */
public class Q895MaximumFrequencyStack {

    @Test
    void test() {
        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        Assertions.assertThat(obj.pop()).isEqualTo(5);
        Assertions.assertThat(obj.pop()).isEqualTo(7);
        Assertions.assertThat(obj.pop()).isEqualTo(5);
        Assertions.assertThat(obj.pop()).isEqualTo(4);
    }

    class FreqStack {

        PriorityQueue<Num> pq;
        Map<Integer, Num> map;
        int pushCount;

        public FreqStack() {
            this.pq = new PriorityQueue<>((o1, o2) -> {
                int size1 = o1.pushIndex.size();
                int size2 = o2.pushIndex.size();
                if (size1 == size2) {
                    return o2.pushIndex.peek() - o1.pushIndex.peek();
                }
                return size2 - size1;
            });
            this.map = new HashMap<>();
            this.pushCount = 0;
        }

        public void push(int val) {
            Num num = map.get(val);
            if (num == null) {
                num = new Num(val);
                map.put(val, num);
            }

            if (pq.contains(num))
                pq.remove(num);

            num.pushIndex.push(pushCount++);
            pq.offer(num);
        }

        public int pop() {
            Num num = pq.poll();
            num.pushIndex.pop();
            if (!num.pushIndex.isEmpty())
                pq.offer(num);
            return num.val;
        }

        class Num {
            int val;
            Stack<Integer> pushIndex;

            public Num(int number) {
                this.val = number;
                this.pushIndex = new Stack<>();
            }

            @Override
            public String toString() {
                return "Num{" +
                        "val=" + val +
                        ", pushIndex=" + pushIndex +
                        '}';
            }
        }
    }
}
