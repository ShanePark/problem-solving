package shane.leetcode.problems.xhard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Runtime: 39 ms, faster than 78.68% of Java online submissions for Maximum Frequency Stack.
 */
public class Q895MaximumFrequencyStack2 {

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
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        int maxCount;

        public void push(int val) {
            int count = countMap.getOrDefault(val, 0) + 1;
            countMap.put(val, count);
            maxCount = Math.max(maxCount, count);
            stackMap.putIfAbsent(count, new Stack<>());
            Stack<Integer> stack = stackMap.get(count);
            stack.add(val);
        }

        public int pop() {
            Stack<Integer> maxStack = stackMap.get(maxCount);
            Integer val = maxStack.pop();
            countMap.put(val, maxCount - 1);
            if (maxStack.isEmpty())
                maxCount--;
            return val;
        }

    }
}
