package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 19 ms, faster than 80.11% of Java online submissions for Power of Three.
Memory Usage: 47.4 MB, less than 46.39% of Java online submissions for Power of Three.
 */
public class Q326PowerOfThree {

    @Test
    public void test() {
        assertThat(isPowerOfThree(27)).isTrue();
        assertThat(isPowerOfThree(0)).isFalse();
        assertThat(isPowerOfThree(9)).isTrue();
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        while (n > 1) {
            if (n % 3 > 0)
                return false;
            n /= 3;
        }
        return true;
    }

}
