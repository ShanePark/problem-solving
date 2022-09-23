package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/discuss/1037347/Java-Bit-manipulation-without-any-library-function-O(n)-time-O(1)-space
 */
public class Q1680ConcatenationOfConsecutiveBinaryNumbers2 {

    @Test
    public void test() {
        assertThat(concatenatedBinary(1)).isEqualTo(1);
        assertThat(concatenatedBinary(3)).isEqualTo(27);
        assertThat(concatenatedBinary(12)).isEqualTo(505379714);
        assertThat(concatenatedBinary(42)).isEqualTo(727837408);
        assertThat(concatenatedBinary(418)).isEqualTo(574174111);
    }

    public int concatenatedBinary(int n) {
        final int MOD = (int) (1e9 + 7);
        long answer = 0;
        int digits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                digits++;
            }
            answer = ((answer << digits) + i) % MOD;
        }

        return (int) answer;
    }
}
