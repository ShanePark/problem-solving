package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime9msBeats57.52%
 */
public class Q2134MinimumSwapsToGroupAll1sTogetherII {

    @Test
    public void test() {
        assertThat(minSwaps(new int[]{0, 0, 0})).isEqualTo(0);
        assertThat(minSwaps(new int[]{1})).isEqualTo(0);
        assertThat(minSwaps(new int[]{0, 1, 0, 1, 0, 1})).isEqualTo(1);
        assertThat(minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0})).isEqualTo(1);
        assertThat(minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0})).isEqualTo(2);
        assertThat(minSwaps(new int[]{1, 1, 0, 0, 1})).isEqualTo(0);
    }

    public int minSwaps(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int[] tmp = new int[nums.length + sum];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
            if (i + nums.length < tmp.length) {
                tmp[i + nums.length] = nums[i];
            }
        }
        nums = tmp;

        int currentSum = 0;
        for (int i = 0; i < sum; i++) {
            currentSum += nums[i];
        }
        int answer = sum - currentSum;
        for (int i = sum; i < nums.length; i++) {
            currentSum += nums[i];
            currentSum -= nums[i - sum];
            answer = Math.min(answer, sum - currentSum);
        }
        return answer;
    }

}
