package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats99.71%
 */
public class Q1437CheckIfAll1sAreAtLeastLengthKPlacesAway {

    @Test
    public void test() {
        assertThat(kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2)).isTrue();
        assertThat(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2)).isFalse();
    }

    public boolean kLengthApart(int[] nums, int k) {
        int lastOne = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            int distance = i - lastOne - 1;
            if (distance < k)
                return false;
            lastOne = i;
        }
        return true;
    }


}
