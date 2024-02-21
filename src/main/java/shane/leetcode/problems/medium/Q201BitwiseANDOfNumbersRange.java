package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q201BitwiseANDOfNumbersRange {

    @Test
    public void test() {
        assertThat(rangeBitwiseAnd(0, 1)).isEqualTo(0);
        assertThat(rangeBitwiseAnd(5, 7)).isEqualTo(4);
        assertThat(rangeBitwiseAnd(0, 2147483647)).isEqualTo(0);
    }

    @Test
    public void overflow() {
        assertThat(rangeBitwiseAnd(2147483646, 2147483647)).isEqualTo(2147483646);
    }

    /**
     * 517 ms
     */
    @Test
    public void tle() {
        assertThat(rangeBitwiseAnd(1073741824, 2147483647)).isEqualTo(1073741824);
    }

    public int rangeBitwiseAnd(int left, int right) {
        int and = left;
        for (int i = left + 1; i <= right && 0 < i; i++) {
            and &= i;
            if (and == 0)
                return 0;
        }
        return and;
    }

}
