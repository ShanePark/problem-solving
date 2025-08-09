package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 35.75%
 */
public class Q231PowerOfTwo3 {

    @Test
    public void test() {
        assertThat(isPowerOfTwo(1)).isTrue();
        assertThat(isPowerOfTwo(16)).isTrue();
        assertThat(isPowerOfTwo(3)).isFalse();
        assertThat(isPowerOfTwo(0)).isFalse();
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        if (n <= 0 || n % 2 == 1)
            return false;
        return isPowerOfTwo(n / 2);
    }

}
