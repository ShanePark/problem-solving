package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 80.60%
 * Memory 41.1 MB Beats 60.8%
 */
public class Q263UglyNumber {

    @Test
    public void test() {
        assertThat(isUgly(0)).isFalse();
        assertThat(isUgly(-2)).isFalse();
        assertThat(isUgly(6)).isTrue();
        assertThat(isUgly(1)).isTrue();
        assertThat(isUgly(14)).isFalse();

    }

    public boolean isUgly(int n) {
        if (n == 0)
            return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }

}
