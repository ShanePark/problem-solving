package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1680ConcatenationOfConsecutiveBinaryNumbers {

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
        BigDecimal answer = new BigDecimal(0);
        for (int i = 1; i <= n; i++) {
            answer = answer
                    .multiply(new BigDecimal(2).pow(Integer.toBinaryString(i).length()))
                    .add(BigDecimal.valueOf(i));
        }

        return answer.remainder(BigDecimal.valueOf(MOD)).intValue();
    }
}
