package shane.leetcode.contest.biweekly.w72;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 5996. Count Equal and Divisible Pairs in an Array
 * User Accepted:0
 * User Tried:0
 * Total Accepted:0
 * Total Submissions:0
 * Difficulty:Easy
 * Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,1,2,2,2,1,3], k = 2
 * Output: 4
 * Explanation:
 * There are 4 pairs that meet all the requirements:
 * - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
 * - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
 * - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
 * - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4], k = 1
 * Output: 0
 * Explanation: Since no value in nums is repeated, there are no pairs (i,j) that meet all the requirements.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i], k <= 100
 */
public class Q2176CountEqualandDivisiblePairsinanArray {

    @Test
    void test() {
        Assertions.assertThat(countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2)).isEqualTo(4);
        Assertions.assertThat(countPairs(new int[]{1, 2, 3, 4}, 1)).isEqualTo(0);
    }

    public int countPairs(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
