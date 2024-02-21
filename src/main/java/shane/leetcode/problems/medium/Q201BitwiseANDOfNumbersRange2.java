package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * not my solution
 */
public class Q201BitwiseANDOfNumbersRange2 {

    @Test
    public void test() {
        assertThat(rangeBitwiseAnd(2, 4)).isEqualTo(0);
        assertThat(rangeBitwiseAnd(5, 7)).isEqualTo(4);
        assertThat(rangeBitwiseAnd(0, 0)).isEqualTo(0);
        assertThat(rangeBitwiseAnd(1, 2147483647)).isEqualTo(0);
    }

    @Test
    public void overflow() {
        assertThat(rangeBitwiseAnd(2147483646, 2147483647)).isEqualTo(2147483646);
    }

    @Test
    public void tle() {
        assertThat(rangeBitwiseAnd(1073741824, 2147483647)).isEqualTo(1073741824);
    }

    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & right - 1;
        }
        return left & right;
    }

}
