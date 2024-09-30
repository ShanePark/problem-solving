package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not mine
 */
public class Q1381DesignAStackWithIncrementOperation3 {
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

        private final int[] stack;
        private final int[] increment;

        private int topIndex = -1;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            increment = new int[maxSize];
        }

        public void push(int x) {
            if (topIndex < stack.length - 1) {
                stack[++topIndex] = x;
            }
        }

        public int pop() {
            if (topIndex < 0) {
                return -1;
            }
            int result = stack[topIndex] + increment[topIndex];

            if (topIndex > 0) {
                increment[topIndex - 1] += increment[topIndex];
            }
            increment[topIndex--] = 0;
            return result;
        }

        public void increment(int k, int val) {
            if (topIndex < 0) {
                return;
            }
            increment[Math.min(topIndex, k - 1)] += val;
        }
    }

}

