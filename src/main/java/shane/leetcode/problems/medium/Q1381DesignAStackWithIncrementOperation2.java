package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1381DesignAStackWithIncrementOperation2 {
    @Test
    public void test() {
        CustomStack c = new CustomStack(3);
        c.push(1);
        c.push(2);
        assertThat(c.pop()).isEqualTo(2);
        c.push(2);
        c.push(3);
        c.push(4);
        c.increment(5, 100);
        c.increment(2, 100);
        assertThat(c.pop()).isEqualTo(103);
        assertThat(c.pop()).isEqualTo(202);
        assertThat(c.pop()).isEqualTo(201);
        assertThat(c.pop()).isEqualTo(-1);
    }

    class CustomStack {

        private final int maxSize;
        private final LinkedList<Integer> list = new LinkedList<>();

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (list.size() < maxSize)
                list.add(x);
        }

        public int pop() {
            if (list.isEmpty())
                return -1;
            return list.remove(list.size() - 1);
        }

        public void increment(int k, int val) {
            k = Math.min(k, list.size());
            for (int i = 0; i < k; i++) {
                list.set(i, list.get(i) + val);
            }
        }
    }

}

