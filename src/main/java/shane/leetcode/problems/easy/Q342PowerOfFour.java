package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
 * Memory Usage: 41.8 MB, less than 19.85% of Java online submissions for Power of Four.
 */
public class Q342PowerOfFour {

    @Test
    public void test() {
        assertThat(isPowerOfFour(16)).isEqualTo(true);
        assertThat(isPowerOfFour(5)).isEqualTo(false);
        assertThat(isPowerOfFour(1)).isEqualTo(true);
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        while (n > 1) {
            if (n % 4 > 0)
                return false;
            n /= 4;
        }
        return true;
    }
}
