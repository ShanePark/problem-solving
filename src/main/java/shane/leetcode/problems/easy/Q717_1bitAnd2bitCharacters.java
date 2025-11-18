package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q717_1bitAnd2bitCharacters {

    @Test
    public void test() {
        assertThat(isOneBitCharacter(new int[]{1, 0, 0})).isTrue();
        assertThat(isOneBitCharacter(new int[]{1, 1, 1, 0})).isFalse();
    }

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                i++;
                if (i == bits.length - 1)
                    return false;
            }
        }
        return true;
    }

}
