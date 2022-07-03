package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q376WiggleSubsequence {

    @Test
    public void test() {
        assertThat(wiggleMaxLength(new int[]{0, 0})).isEqualTo(1);
        assertThat(wiggleMaxLength(new int[]{0, 0, 0, 0})).isEqualTo(1);
        assertThat(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5})).isEqualTo(6);
        assertThat(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})).isEqualTo(7);
        assertThat(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).isEqualTo(2);
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1)
            return 1;
        int cnt = 1;
        int cur = nums[0];
        Boolean isAscending = null;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (isAscending == null) {
                cnt++;
                if (cur < n) {
                    isAscending = true;
                } else if (cur > n) {
                    isAscending = false;
                } else {
                    cnt--;
                }
            } else if (isAscending) {
                if (cur > n) {
                    isAscending = false;
                    cnt++;
                }
            } else {
                if (cur < n) {
                    isAscending = true;
                    cnt++;
                }
            }
            cur = n;
        }
        return cnt;
    }

}
