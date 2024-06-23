package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime49msBeats43.70%
 */
public class Q1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit2 {

    @Test
    public void test() {
        assertThat(longestSubarray(new int[]{8, 2, 4, 7}, 4)).isEqualTo(2);
        assertThat(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5)).isEqualTo(4);
        assertThat(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0)).isEqualTo(3);
    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 1;
        map.put(nums[0], 1);
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > limit) {
                Integer cnt = map.get(nums[left]);
                if (cnt == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], cnt - 1);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
