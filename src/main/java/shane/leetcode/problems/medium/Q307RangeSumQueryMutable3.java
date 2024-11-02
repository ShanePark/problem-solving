package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q307RangeSumQueryMutable3 {

    @Test
    public void test() {
        NumArray n = new NumArray(new int[]{1, 3, 5});
        assertThat(n.sumRange(1, 2)).isEqualTo(8);
        assertThat(n.sumRange(0, 2)).isEqualTo(9);
        n.update(1, 2);
        assertThat(n.sumRange(0, 2)).isEqualTo(8);
        assertThat(n.sumRange(1, 2)).isEqualTo(7);
    }

    /**
     * 2 ms
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

    @Test
    public void test3() {
        NumArray n = new NumArray(new int[]{7, 2, 7, 2, 0});
        n.update(4, 6);
        n.update(0, 2);
        n.update(0, 9);
        assertThat(n.sumRange(4, 4)).isEqualTo(6);
        n.update(3, 8);
        assertThat(n.sumRange(0, 4)).isEqualTo(32);
        n.update(4, 1);
        assertThat(n.sumRange(0, 3)).isEqualTo(26);
        assertThat(n.sumRange(0, 4)).isEqualTo(27);
        n.update(0, 4);
    }

    class NumArray {

        int[] sums;
        int pivot = 0;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }

        }

        public void update(int index, int val) {
            int original = (index == 0) ? sums[index] + pivot : (sums[index] - sums[index - 1]);
            int diff = val - original;
            if (index < sums.length / 2) {
                for (int i = 0; i < index; i++) {
                    sums[i] -= diff;
                }
                pivot += diff;
            } else {
                for (int i = index; i < sums.length; i++) {
                    sums[i] += diff;
                }
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0)
                return sums[right] + pivot;
            return sums[right] - sums[left - 1];
        }
    }

}
