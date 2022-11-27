package shane.leetcode.contest.weekly.w321;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q4 {

    @Test
    public void test() {
        assertThat(countSubarrays(new int[]{2, 3, 1}, 3)).isEqualTo(1);
        assertThat(countSubarrays(new int[]{3, 2, 1, 4, 5}, 4)).isEqualTo(3);
    }

    /**
     * 3sec 309ms
     */
    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        assertThat(countSubarrays(arr, 50000));
    }

    public int countSubarrays(int[] nums, int k) {
        int indexOfK = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                indexOfK = i;
                break;
            }
        }

        int[][] dp = new int[nums.length][2];
        int smallerCnt = 0;
        int biggerCnt = 0;
        for (int i = indexOfK - 1; i >= 0; i--) {
            int num = nums[i];
            if (num < k) {
                smallerCnt++;
            } else {
                biggerCnt++;
            }
            dp[i] = new int[]{smallerCnt, biggerCnt};
        }

        smallerCnt = 0;
        biggerCnt = 0;
        for (int i = indexOfK + 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < k) {
                smallerCnt++;
            } else {
                biggerCnt++;
            }
            dp[i] = new int[]{smallerCnt, biggerCnt};
        }

        int cnt = 0;

        for (int left = indexOfK; left >= 0; left--) {
            for (int right = indexOfK; right < nums.length; right++) {
                int small = dp[left][0] + dp[right][0];
                int big = dp[left][1] + dp[right][1];
                if (small == big || small == big - 1) {
                    cnt++;
                }
            }
        }

        return cnt;

    }

}
