package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats100.00%
 */
public class Q592FractionAdditionAndSubtraction {

    @Test
    public void test() {
        assertThat(fractionAddition("-1/2+1/2")).isEqualTo("0/1");
        assertThat(fractionAddition("-1/2+1/2+1/3")).isEqualTo("1/3");
        assertThat(fractionAddition("1/3-1/2")).isEqualTo("-1/6");
        assertThat(fractionAddition("1/3+2/3")).isEqualTo("1/1");
    }

    public String fractionAddition(String expression) {
        List<Fraction> fractions = parse(expression);
        Fraction cur = fractions.get(0);
        for (int i = 1; i < fractions.size(); i++) {
            cur.add(fractions.get(i));
        }
        return cur.toString();
    }

    private List<Fraction> parse(String expression) {
        List<Fraction> list = new ArrayList<>();
        char sign = ' ';
        int numerator = 0;
        int curNum = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case '+':
                case '-':
                    if (sign != ' ') {
                        list.add(new Fraction(sign, numerator, curNum));
                        numerator = 0;
                        curNum = 0;
                    }
                    sign = c;

                    break;
                case '/':
                    numerator = curNum;
                    curNum = 0;
                    break;
                default:
                    if (sign == ' ')
                        sign = '+';
                    curNum = curNum * 10 + c - '0';
                    break;
            }
        }
        list.add(new Fraction(sign, numerator, curNum));
        return list;
    }

    static class Fraction {
        int sign;
        int numerator;
        int denominator;

        public Fraction(char sign, int numerator, int denominator) {
            this.sign = sign == '+' ? 1 : -1;
            this.numerator = numerator;
            this.denominator = denominator;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (sign == -1) {
                sb.append('-');
            }
            sb.append(numerator);
            sb.append('/');
            sb.append(denominator);
            return sb.toString();
        }

        public void add(Fraction fraction) {
            // finding a common denominator
            int gsd = getGsd(this.denominator, fraction.denominator);
            int newDenominator = denominator * fraction.denominator / gsd;

            // add
            this.numerator = this.numerator * newDenominator / denominator;
            fraction.numerator = fraction.numerator * newDenominator / fraction.denominator;
            this.numerator = this.sign * this.numerator + fraction.sign * fraction.numerator;
            this.denominator = newDenominator;
            if (this.numerator >= 0) {
                this.sign = 1;
            } else {
                this.sign = -1;
                this.numerator *= -1;
            }
            if (this.numerator == 0) {
                this.denominator = 1;
            }

            simplifying();
        }

        private void simplifying() {
            int gcd = getGsd(numerator, denominator);
            if (gcd == 1) {
                return;
            }
            this.numerator /= gcd;
            this.denominator /= gcd;
        }

        private int getGsd(int num1, int num2) {
            int gsd = 1;
            int min = Math.min(num1, num2);
            for (int i = 2; i <= min; i++) {
                if (num1 % i == 0 && num2 % i == 0) {
                    gsd = i;
                }
            }
            return gsd;
        }
    }

}
