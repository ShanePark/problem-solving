package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q231PowerOfTwo2 {

    @Test
    public void test() {
        assertThat(isPowerOfTwo(1)).isTrue();
        assertThat(isPowerOfTwo(16)).isTrue();
        assertThat(isPowerOfTwo(3)).isFalse();
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 2 == 1)
            return false;
        return isPowerOfTwo(n / 2);
    }

}
