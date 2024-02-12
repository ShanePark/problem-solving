package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Runtime 4 ms Beats 55.98% of users with Java
 */
public class Q169MajorityElement3 {

    @Test
    void test() {
        Assertions.assertThat(majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
        Assertions.assertThat(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
