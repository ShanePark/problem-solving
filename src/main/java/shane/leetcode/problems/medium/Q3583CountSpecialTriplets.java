package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 31
 * ms
 * Beats
 * 96.90%
 */
public class Q3583CountSpecialTriplets {

    @Test
    public void test() {
        assertThat(specialTriplets(new int[]{6, 3, 6})).isEqualTo(1);
        assertThat(specialTriplets(new int[]{0, 1, 0, 0})).isEqualTo(1);
        assertThat(specialTriplets(new int[]{8, 4, 2, 8, 4})).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(specialTriplets(new int[100000])).isEqualTo(665533373);
        assertThat(specialTriplets(new int[]{44398, 26000, 5342, 21914, 50941, 52738, 19722, 9106, 23223})).isEqualTo(0);
    }

    final int MOD = (int) 1e9 + 7;

    public int specialTriplets(int[] nums) {
        int[] left = new int[100001];
        int[] right = new int[100001];
        left[nums[0]] = 1;
        for (int i = 1; i < nums.length; i++) {
            right[nums[i]]++;
        }
        long answer = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int n = nums[i];
            right[n]--;
            if (n * 2 < left.length) {
                answer = (answer + (long) left[n * 2] * right[n * 2]) % MOD;
            }
            left[n]++;
        }
        return (int) answer;
    }

}
