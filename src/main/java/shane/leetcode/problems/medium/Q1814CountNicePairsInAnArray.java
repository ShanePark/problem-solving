package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime Details 61ms Beats 21.55%of users with Java
 * Memory Details 53.99MB Beats 92.59%of users with Java
 */
public class Q1814CountNicePairsInAnArray {

    @Test
    public void test() {
        org.assertj.core.api.Assertions.assertThat(countNicePairs(new int[]{432835222, 112141211, 5408045, 456281503, 283322436, 414281561, 37773, 286505682})).isEqualTo(6);
        org.assertj.core.api.Assertions.assertThat(countNicePairs(new int[]{42, 11, 1, 97})).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(countNicePairs(new int[]{13, 10, 35, 24, 76})).isEqualTo(4);
    }

    final int MOD = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> diffRevCnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rev = rev(nums[i]);
            int diff = nums[i] - rev;
            diffRevCnt.merge(diff, 1, Integer::sum);
        }
        int sum = 0;
        for (Integer v : diffRevCnt.values()) {
            if (v == 1)
                continue;
            long comb = (long)v * (v - 1) / 2;
            sum = (int) ((comb + sum) % MOD);
        }
        return sum;
    }

    private int rev(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        return Integer.valueOf(sb.reverse().toString());
    }

}
