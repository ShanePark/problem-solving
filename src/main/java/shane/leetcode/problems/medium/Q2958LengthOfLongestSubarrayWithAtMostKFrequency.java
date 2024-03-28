package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 59 ms Beats 88.56% of users with Java
 */
public class Q2958LengthOfLongestSubarrayWithAtMostKFrequency {

    @Test
    public void test() {
        assertThat(maxSubarrayLength(new int[]{2, 2, 3}, 1)).isEqualTo(2);
        assertThat(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2)).isEqualTo(6);
        assertThat(maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1)).isEqualTo(2);
        assertThat(maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 4)).isEqualTo(4);
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Set<Integer> failSet = new HashSet<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        int max = 0;

        while (left < nums.length) {
            while (failSet.isEmpty() && right < nums.length) {
                int num = nums[right];
                Integer newCnt = cnt.merge(num, 1, Integer::sum);
                if (newCnt > k) {
                    failSet.add(num);
                } else {
                    max = Math.max(max, right - left + 1);
                }
                right++;
            }
            // move left
            int num = nums[left++];
            Integer newCnt = cnt.merge(num, -1, Integer::sum);
            if (newCnt == k) {
                failSet.remove(num);
            }
        }
        return max;
    }

}
