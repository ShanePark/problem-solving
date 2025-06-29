package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Cache modPow so much faster
 * Runtime 33 ms Beats 100%
 * Memory 51.9 MB Beats 15.69%
 */
public class Q1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition7 {

    @Test
    void test() {
        assertThat(numSubseq(new int[]{3, 5, 6, 7}, 9)).isEqualTo(4);
        assertThat(numSubseq(new int[]{3, 3, 6, 8}, 10)).isEqualTo(6);
        assertThat(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12)).isEqualTo(61);
        assertThat(numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22)).isEqualTo(272187084);
    }

    @Test
    void tle() {
        int[] arr = new int[100000];
        Arrays.fill(arr, 1);
        numSubseq(arr, 1000000);
    }

    final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        int[] modPowCache = new int[nums.length];
        modPowCache[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            modPowCache[i] = (modPowCache[i - 1] * 2) % MOD;
        }

        Arrays.sort(nums);
        int answer = 0;
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            if (nums[left] + nums[right] > target) {
                right--;
                continue;
            }
            answer = (answer + modPowCache[right - left]) % MOD;
            left++;
        }
        return answer;
    }

}
