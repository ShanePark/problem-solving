package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q166FractionToRecurringDecimal {

    @Test
    public void test() {
        assertThat(fractionToDecimal(1, 2)).isEqualTo("0.5");
        assertThat(fractionToDecimal(2, 1)).isEqualTo("2");
        assertThat(fractionToDecimal(4, 333)).isEqualTo("0.(012)");
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder answer = new StringBuilder();
        answer.append((numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-");
        long numerator_ = Math.abs((long) numerator);
        long denominator_ = Math.abs((long) denominator);
        answer.append(numerator_ / denominator_);
        long remainder = numerator_ % denominator_;
        if (remainder == 0)
            return answer.toString();
        answer.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            Integer repeatIndex = map.putIfAbsent(remainder, answer.length());
            if (repeatIndex != null) {
                return answer.substring(0, repeatIndex) + "(" + answer.substring(repeatIndex) + ")";
            }
            remainder *= 10;
            answer.append(remainder / denominator_);
            remainder = remainder % denominator_;
        }
        return answer.toString();
    }
}
