package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition3 {

    @Test
    void test() {
        assertThat(numSubseq(new int[]{3, 4, 5, 7, 7, 7, 10}, 12)).isEqualTo(56);
        assertThat(numSubseq(new int[]{9, 25, 9, 28, 24, 12, 17, 8, 28, 7, 21, 25, 10, 2, 16, 19, 12, 13, 15, 28, 14, 12, 24, 9, 6, 7, 2, 15, 19, 13, 30, 30, 23, 19, 11, 3, 17, 2, 14, 20, 22, 30, 12, 1, 11, 2, 2, 20, 20, 27, 15, 9, 10, 4, 12, 30, 13, 5, 2, 11, 29, 5, 3, 13, 22, 5, 16, 19, 7, 19, 11, 16, 11, 25, 29, 21, 29, 3, 2, 9, 20, 15, 9}, 32))
                .isEqualTo(91931447);
        assertThat(numSubseq(new int[]{7, 10, 7, 3, 7, 5, 4}, 12)).isEqualTo(56);
        assertThat(numSubseq(new int[]{3, 5, 6, 7}, 9)).isEqualTo(4);
        assertThat(numSubseq(new int[]{3, 3, 6, 8}, 10)).isEqualTo(6);
        assertThat(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12)).isEqualTo(61);
    }

    @Test
    void tle() {
        int[] arr = new int[100000];
        Arrays.fill(arr, 1);
        numSubseq(arr, 1000000);
    }

    final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int answer = 0;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
                continue;
            }
            answer = (answer + modPow(right - left)) % MOD;
            left++;
        }

        return answer;
    }

    private int modPow(int pow) {
        System.err.println("pow = " + pow);
        int number = 1;
        for (int i = 0; i < pow; i++) {
            number = (int) (((long) number * 2) % MOD);
        }
        return number;
    }

}
