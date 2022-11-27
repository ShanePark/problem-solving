package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q446ArithmeticSlicesIISubsequence {

    @Test
    public void test() {
        assertThat(numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296})).isEqualTo(0);
        assertThat(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10})).isEqualTo(7);
        assertThat(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7})).isEqualTo(16);
    }

    // 383 ms
    @Test
    public void tle() {
        assertThat(numberOfArithmeticSlices(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    int cnt = 0;

    public int numberOfArithmeticSlices(int[] nums) {
        cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            bt(nums, i, null, 1);
        }
        return cnt;
    }

    private void bt(int[] nums, int index, Long diff, int length) {
        int lastNumber = nums[index];
        if (length >= 3) {
            cnt++;
        }
        for (int i = index + 1; i < nums.length; i++) {
            int nextNumber = nums[i];
            if (diff == null || diff == (long) nextNumber - lastNumber) {
                bt(nums, i, (long) nextNumber - lastNumber, length + 1);
            }
        }
    }
}
