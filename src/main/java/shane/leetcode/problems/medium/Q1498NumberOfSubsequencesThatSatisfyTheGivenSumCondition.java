package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 5 / 62 testcases passed
 */
public class Q1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    @Test
    void test() {
        assertThat(numSubseq(new int[]{3, 5, 6, 7}, 9)).isEqualTo(4);
        assertThat(numSubseq(new int[]{3, 3, 6, 8}, 10)).isEqualTo(6);
        assertThat(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12)).isEqualTo(61);
    }

    @Test
    void wrong() {
        assertThat(numSubseq(new int[]{7, 10, 7, 3, 7, 5, 4}, 12)).isEqualTo(56);
    }

    final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            int length = nums.length - i;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (min + max > target) {
                    length = j - i;
                    break;
                }
            }
            if (length > 0) {
                answer = (int) ((answer + Math.pow(2, length - 1)) % MOD);
            }
        }
        return answer;
    }

}
