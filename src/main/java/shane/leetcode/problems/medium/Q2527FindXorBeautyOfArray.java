package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100%
 * Memory 58.6 MB Beats 81.66%
 */
public class Q2527FindXorBeautyOfArray {

    @Test
    public void test() {
        assertThat(xorBeauty(new int[]{1, 4})).isEqualTo(5);
        assertThat(xorBeauty(new int[]{15, 45, 20, 2, 34, 35, 5, 44, 32, 30})).isEqualTo(34);
    }

    public int xorBeauty(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
}
