package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
9ms
Beats16.02%
 */
public class Q3191MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{0, 1, 1, 1, 0, 0})).isEqualTo(3);
        assertThat(minOperations(new int[]{0, 1, 1, 1})).isEqualTo(-1);
    }

    public int minOperations(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1) {
                continue;
            }
            answer++;
            nums[i] = (nums[i] + 1) % 2;
            nums[i + 1] = (nums[i + 1] + 1) % 2;
            nums[i + 2] = (nums[i + 2] + 1) % 2;
        }
        if (nums[nums.length - 1] * nums[nums.length - 2] == 0)
            return -1;
        return answer;
    }

}
