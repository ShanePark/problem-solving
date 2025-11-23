package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1262GreatestSumDivisibleByThree {

    @Test
    public void test() {
        assertThat(maxSumDivThree(new int[]{3, 6, 5, 1, 8})).isEqualTo(18);
        assertThat(maxSumDivThree(new int[]{4})).isEqualTo(0);
        assertThat(maxSumDivThree(new int[]{1, 2, 3, 4, 4})).isEqualTo(12);
    }

    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] next = new int[3];
            System.arraycopy(dp, 0, next, 0, 3);
            for (int mod = 0; mod < 3; ++mod) {
                int nextMod = (mod + num % 3) % 3;
                next[nextMod] = Math.max(next[nextMod], dp[mod] + num);
            }
            dp = next;
        }
        return dp[0];
    }

}
