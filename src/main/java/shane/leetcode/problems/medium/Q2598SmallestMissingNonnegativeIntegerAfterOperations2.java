package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7ms
 * Beats68.53%
 */
public class Q2598SmallestMissingNonnegativeIntegerAfterOperations2 {

    @Test
    void test() {
        assertThat(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5)).isEqualTo(4);
        assertThat(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(findSmallestInteger(new int[]{3, 0, 3, 2, 4, 2, 1, 1, 0, 4}, 5)).isEqualTo(10);
    }

    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int num : nums) {
            int mod = (num % value + value) % value;
            cnt[mod]++;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (--cnt[i % value] < 0)
                return i;
        }
        return -1;
    }

}
