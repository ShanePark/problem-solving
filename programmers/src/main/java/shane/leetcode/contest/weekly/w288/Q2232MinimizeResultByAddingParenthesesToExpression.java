package shane.leetcode.contest.weekly.w288;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2232MinimizeResultByAddingParenthesesToExpression {

    @Test
    public void test() {
        assertThat(minimizeResult("247+38")).isEqualTo("2(47+38)");
        assertThat(minimizeResult("12+34")).isEqualTo("1(2+3)4");
        assertThat(minimizeResult("999+999")).isEqualTo("(999+999)");
    }


    public String minimizeResult(String expression) {
        long min = Long.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        int plusIndex = expression.indexOf('+');
        for (int left = 0; left < plusIndex; left++) {
            for (int right = plusIndex + 2; right <= expression.length(); right++) {
                long calc = calc(expression, left, right, plusIndex);
                if (calc < min) {
                    minLeft = left;
                    minRight = right;
                }
                min = Math.min(min, calc);
            }
        }
        return expression.substring(0, minLeft) + "(" + expression.substring(minLeft, minRight) + ")" + expression.substring(minRight);
    }

    private long calc(String expression, int left, int right, int plusIndex) {
        int first = 0 == left ? 1 : Integer.parseInt(expression.substring(0, left));
        int second = Integer.parseInt(expression.substring(left, plusIndex)) + Integer.parseInt(expression.substring(plusIndex + 1, right));
        int third = right == expression.length() ? 1 : Integer.parseInt(expression.substring(right));
        return first * second * third;
    }
}
