package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7ms
 * Beats100.00%
 */
public class Q326PowerOfThree2 {

    @Test
    public void test() {
        assertThat(isPowerOfThree(27)).isTrue();
        assertThat(isPowerOfThree(0)).isFalse();
        assertThat(isPowerOfThree(-1)).isFalse();
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 3 > 0)
            return false;
        return isPowerOfThree(n / 3);
    }

}
