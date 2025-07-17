package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3202FindTheMaximumLengthOfValidSubsequenceII {

    @Test
    public void test() {
        assertThat(maximumLength(new int[]{1, 2, 3, 4, 5}, 2)).isEqualTo(5);
        assertThat(maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3)).isEqualTo(4);
    }

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int answer = 0;
        for (int num : nums) {
            num %= k;
            for (int before = 0; before < k; before++) {
                dp[before][num] = dp[num][before] + 1;
                answer = Math.max(answer, dp[before][num]);
            }
        }
        return answer;
    }

}
