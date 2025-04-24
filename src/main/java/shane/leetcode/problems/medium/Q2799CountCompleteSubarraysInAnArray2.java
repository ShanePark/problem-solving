package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 259ms
 * Beats11.40%
 */
public class Q2799CountCompleteSubarraysInAnArray2 {

    @Test
    public void test() {
        assertThat(countCompleteSubarrays(new int[]{1, 3, 1, 2, 2})).isEqualTo(4);
        assertThat(countCompleteSubarrays(new int[]{5, 5, 5, 5})).isEqualTo(10);
    }

    public int countCompleteSubarrays(int[] nums) {
        int completeCnt = getCompleteCnt(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> cnt = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                cnt.add(nums[j]);
                if (cnt.size() < completeCnt)
                    continue;
                sum += nums.length - j;
                break;
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
