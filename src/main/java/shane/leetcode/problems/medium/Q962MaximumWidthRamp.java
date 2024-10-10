package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q962MaximumWidthRamp {

    @Test
    public void test() {
        assertThat(maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5})).isEqualTo(4);
        assertThat(maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1})).isEqualTo(7);
    }

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (s.empty() || cur < nums[s.peek()]) {
                s.add(i);
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            while (!s.empty() && nums[s.peek()] <= nums[i]) {
                answer = Math.max(answer, i - s.pop());
            }
        }
        return answer;
    }

}
