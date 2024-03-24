package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 34 ms Beats 19.57% of users with Java
 */
public class Q287FindTheDuplicateNumber3 {

    @Test
    public void test() {
        assertThat(findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
        assertThat(findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
        assertThat(findDuplicate(new int[]{3, 3, 3, 3, 3})).isEqualTo(3);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

}
