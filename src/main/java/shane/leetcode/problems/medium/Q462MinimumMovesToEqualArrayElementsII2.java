package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q462MinimumMovesToEqualArrayElementsII2 {

    @Test
    public void test() {
        assertThat(minMoves2(new int[]{203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143}))
                .isEqualTo(2127271182);
        assertThat(minMoves2(new int[]{1, 0, 0, 8, 6})).isEqualTo(14);
        assertThat(minMoves2(new int[]{1, 2, 3})).isEqualTo(2);
        assertThat(minMoves2(new int[]{5, 6, 2})).isEqualTo(4);
        assertThat(minMoves2(new int[]{1, 10, 2, 9})).isEqualTo(16);
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        return getMoves(nums, nums[nums.length / 2]);
    }

    private int getMoves(int[] nums, int i) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(i - num);
        }
        return sum;
    }
}
