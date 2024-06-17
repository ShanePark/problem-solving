package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 3msBeats97.79%
 */
public class Q633SumOfSquareNumbers {

    @Test
    public void test() {
        assertThat(judgeSquareSum(0)).isTrue();
        assertThat(judgeSquareSum(1_999_967_843)).isFalse();
        assertThat(judgeSquareSum(5)).isTrue();
        assertThat(judgeSquareSum(3)).isFalse();
        assertThat(judgeSquareSum(1_999_967_845)).isTrue();
        assertThat(judgeSquareSum(1_999_967_842)).isTrue();
    }

    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        while (0 <= sqrt) {
            if (isSquare(c - sqrt * sqrt)) {
                return true;
            }
            sqrt--;
        }
        return false;
    }

    private boolean isSquare(int i) {
        int sqrt = (int) Math.sqrt(i);
        return sqrt * sqrt == i;
    }

}
