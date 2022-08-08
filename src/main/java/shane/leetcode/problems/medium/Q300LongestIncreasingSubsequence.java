package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 260 ms, faster than 10.77% of Java online submissions for Longest Increasing Subsequence.
 * Memory Usage: 117 MB, less than 9.94% of Java online submissions for Longest Increasing Subsequence.
 */
public class Q300LongestIncreasingSubsequence {

    @Test
    public void test() {
        assertThat(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6})).isEqualTo(6);
        assertThat(lengthOfLIS(new int[]{-2, -1})).isEqualTo(2);
        assertThat(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
        assertThat(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})).isEqualTo(4);
        assertThat(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})).isEqualTo(1);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            int n = nums[i];
            if (map.getOrDefault(1, -10001) < n) {
                map.put(1, n);
            }
            int j = 1;
            while (map.containsKey(j)) {
                Integer maxOfIndex = map.get(j);
                if (n < maxOfIndex) {
                    Integer nextMax = map.get(j + 1);
                    if (nextMax == null || nextMax < n) {
                        map.put(j + 1, n);
                    }
                }
                j++;
            }
        }
        return map.keySet().stream().max(Comparator.naturalOrder()).get();
    }
}
