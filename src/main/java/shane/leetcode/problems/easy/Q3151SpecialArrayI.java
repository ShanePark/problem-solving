package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q3151SpecialArrayI {

    @Test
    public void test() {
        assertThat(isArraySpecial(new int[]{1})).isTrue();
        assertThat(isArraySpecial(new int[]{2, 1, 4})).isTrue();
        assertThat(isArraySpecial(new int[]{4, 3, 1, 6})).isFalse();
    }

    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] + nums[i]) % 2 == 0)
                return false;
        }
        return true;
    }

}
