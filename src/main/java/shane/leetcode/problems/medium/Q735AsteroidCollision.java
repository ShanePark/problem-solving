package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 10 ms Beats 73.15%
 * Memory 43.9 MB Beats 78%
 */
public class Q735AsteroidCollision {

    @Test
    public void test() {
        assertThat(asteroidCollision(new int[]{1, -2, -2, -2})).isEqualTo(new int[]{-2, -2, -2});
        assertThat(asteroidCollision(new int[]{-2, -1, 1, 2})).isEqualTo(new int[]{-2, -1, 1, 2});
        assertThat(asteroidCollision(new int[]{5, 10, -5})).isEqualTo(new int[]{5, 10});
        assertThat(asteroidCollision(new int[]{8, -8})).isEqualTo(new int[]{});
        assertThat(asteroidCollision(new int[]{10, 2, -5})).isEqualTo(new int[]{10});
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            if (stack.isEmpty() || cur > 0) {
                stack.push(cur);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0) {
                Integer before = stack.pop();
                if (cur == -before) {
                    cur = 0;
                    break;
                }
                if (-cur < before) {
                    stack.push(before);
                    cur = 0;
                    break;
                }
            }
            if (cur < 0) {
                stack.push(cur);
            }
        }
        return stackToArray(stack);
    }

    private int[] stackToArray(Stack<Integer> stack) {
        int[] answer = new int[stack.size()];
        int i = answer.length - 1;
        while (!stack.isEmpty()) {
            answer[i--] = stack.pop();
        }
        return answer;
    }

}
