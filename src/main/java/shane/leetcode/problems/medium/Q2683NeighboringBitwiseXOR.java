package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats100.00%
 */
public class Q2683NeighboringBitwiseXOR {

    @Test
    public void test() {
        assertThat(doesValidArrayExist(new int[]{0, 0, 0})).isTrue();
        assertThat(doesValidArrayExist(new int[]{0, 0})).isTrue();
        assertThat(doesValidArrayExist(new int[]{1, 1})).isTrue();
        assertThat(doesValidArrayExist(new int[]{0})).isTrue();
        assertThat(doesValidArrayExist(new int[]{1})).isFalse();
        assertThat(doesValidArrayExist(new int[]{1, 1, 0})).isTrue();
        assertThat(doesValidArrayExist(new int[]{1, 0})).isFalse();
    }

    public boolean doesValidArrayExist(int[] derived) {
        int cur = derived[0];
        for (int i = 1; i < derived.length; i++) {
            cur ^= derived[i];
        }
        return (cur ^ derived[0]) == derived[0];
    }

}
