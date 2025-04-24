package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 281ms
 * Beats8.31%
 */
public class Q2799CountCompleteSubarraysInAnArray {

    @Test
    public void test() {
        assertThat(countCompleteSubarrays(new int[]{1, 3, 1, 2, 2})).isEqualTo(4);
        assertThat(countCompleteSubarrays(new int[]{5, 5, 5, 5})).isEqualTo(10);
    }

    public int countCompleteSubarrays(int[] nums) {
        int completeCnt = getCompleteCnt(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                cntMap.merge(nums[j], 1, Integer::sum);
                if (cntMap.size() == completeCnt)
                    sum++;
            }
        }
        return sum;
    }

    private static int getCompleteCnt(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }

}
