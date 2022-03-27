package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2216MinimumDeletionsToMakeArrayBeautiful {

    @Test
    public void test() {
        assertThat(minDeletion(new int[]{1, 1, 2, 3, 5})).isEqualTo(1);
        assertThat(minDeletion(new int[]{1, 1, 2, 2, 3, 3})).isEqualTo(2);
    }

    public int minDeletion(int[] nums) {
        int cnt = 0;
        int before = -1;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (index % 2 == 0) {
                before = nums[i];
                index++;
            } else {
                if (nums[i] != before) {
                    index++;
                    before = -1;
                } else {
                    cnt++;
                }
            }
        }

        return before < 0 ? cnt : cnt + 1;
    }
}
