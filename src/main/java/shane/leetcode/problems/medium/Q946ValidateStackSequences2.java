package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 85.90%
 * Memory 42.4 MB Beats 43.6%
 */
public class Q946ValidateStackSequences2 {

    @Test
    void test() {
        assertThat(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1})).isTrue();
        assertThat(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2})).isFalse();
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int poppedLeft = 0;
        for (int i = 0; i < length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[poppedLeft]) {
                stack.pop();
                poppedLeft++;
            }
        }
        return stack.isEmpty();
    }

}
