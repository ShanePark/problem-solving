package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q307RangeSumQueryMutable {

    @Test
    public void test() {
        NumArray n = new NumArray(new int[]{1, 3, 5});
        assertThat(n.sumRange(0, 2)).isEqualTo(9);
        n.update(1, 2);
        assertThat(n.sumRange(0, 2)).isEqualTo(8);
    }

    /**
     * 330 ms
     */
    @Test
    public void test2() {
        final int BIG = 3 * 10000;
        int[] arr = new int[BIG];
        NumArray n = new NumArray(arr);
        for (int i = 0; i < BIG; i++) {
            n.update(0, 0);
            n.sumRange(0, BIG - 1);
        }
    }

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int index, int val) {
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
