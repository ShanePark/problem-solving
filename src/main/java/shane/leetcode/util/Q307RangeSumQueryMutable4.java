package shane.leetcode.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 * https://leetcode.com/problems/range-sum-query-mutable/discuss/75753/Java-using-Binary-Indexed-Tree-with-clear-explanation
 */
@SuppressWarnings("ALL")
public class Q307RangeSumQueryMutable4 {

    @Test
    public void test() {
        NumArray n = new NumArray(new int[]{1, 3, 5});
        assertThat(n.sumRange(1, 2)).isEqualTo(8);
        assertThat(n.sumRange(0, 2)).isEqualTo(9);
        n.update(1, 2);
        assertThat(n.sumRange(0, 2)).isEqualTo(8);
        assertThat(n.sumRange(1, 2)).isEqualTo(7);
    }

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

        int[] nums;
        int[] binaryIndexedTree;

        public NumArray(int[] nums) {
            this.nums = nums;
            binaryIndexedTree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                init(i, nums[i]);
            }
        }

        private void init(int i, int val) {
            i++;
            while (i <= nums.length) {
                binaryIndexedTree[i] += val;
                i += (i & -i);
            }
        }

        public void update(int index, int val) {
            int diff = val - nums[index];
            nums[index] = val;
            init(index, diff);
        }

        public int sumRange(int left, int right) {
            return getSum(right + 1) - getSum(left);
        }

        private int getSum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += binaryIndexedTree[i];
                i -= (i & -i);
            }
            return sum;
        }
    }

}
