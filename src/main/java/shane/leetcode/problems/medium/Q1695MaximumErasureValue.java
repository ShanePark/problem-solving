package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1695MaximumErasureValue {

    @Test
    public void test() {
        assertThat(maximumUniqueSubarray(new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7})).isEqualTo(28);
        assertThat(maximumUniqueSubarray(new int[]
                {187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434}))
                .isEqualTo(16911);
        assertThat(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6})).isEqualTo(17);
        assertThat(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5})).isEqualTo(8);
    }

    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int left = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                max = Math.max(max, sum);
            } else {
                while ((nums[left] != nums[i])) {
                    set.remove(nums[left]);
                    sum -= nums[left++];
                }
                left++;
            }
        }
        return max;
    }
}
