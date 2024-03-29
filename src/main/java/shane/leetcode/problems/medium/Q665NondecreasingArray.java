package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 97.53% of Java online submissions for Non-decreasing Array.
 * Memory Usage: 54.5 MB, less than 12.01% of Java online submissions for Non-decreasing Array.
 */
public class Q665NondecreasingArray {

    @Test
    public void test() {
        assertThat(checkPossibility(new int[]{3, 4, 2, 3})).isFalse();
        assertThat(checkPossibility(new int[]{1, 2, 0})).isTrue();
        assertThat(checkPossibility(new int[]{4, 2, 1})).isFalse();
        assertThat(checkPossibility(new int[]{9, 3, 4, 1})).isFalse();
        assertThat(checkPossibility(new int[]{4, 2, 3})).isTrue();
    }

    public boolean checkPossibility(int[] nums) {
        int before2 = Integer.MIN_VALUE;
        int before = nums[0];
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (before > cur) {
                if (flag)
                    return false;
                if (before2 > cur) {
                    cur = before;
                } else {
                    before = before2;
                }
                flag = true;
            }
            before2 = before;
            before = cur;
        }
        return true;
    }

}
