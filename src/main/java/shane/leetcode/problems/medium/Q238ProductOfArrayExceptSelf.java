package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100.00% of users with Java
 */
public class Q238ProductOfArrayExceptSelf {

    @Test
    public void test() {
        assertThat(productExceptSelf(new int[]{1, 2, 3, 4})).containsExactly(24, 12, 8, 6);
        assertThat(productExceptSelf(new int[]{-1, 1, 0, -3, 3})).containsExactly(0, 0, 9, 0, 0);
        assertThat(productExceptSelf(new int[]{1, 0, 0})).containsExactly(0, 0, 0);
    }

    public int[] productExceptSelf(int[] nums) {
        int zeroIndex = -1;
        int mul = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex != -1)
                    return new int[nums.length];
                zeroIndex = i;
                continue;
            }
            mul *= nums[i];
        }

        if (zeroIndex != -1) {
            nums = new int[nums.length];
            nums[zeroIndex] = mul;
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = mul / nums[i];
        }

        return nums;
    }

}
