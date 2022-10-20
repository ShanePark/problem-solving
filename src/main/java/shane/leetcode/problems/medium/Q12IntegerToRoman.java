package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 6 ms, faster than 91.95% of Java online submissions for Integer to Roman.
 * Memory Usage: 42.4 MB, less than 88.16% of Java online submissions for Integer to Roman.
 */
public class Q12IntegerToRoman {

    @Test
    public void test() {
        assertThat(intToRoman(3)).isEqualTo("III");
        assertThat(intToRoman(58)).isEqualTo("LVIII");
        assertThat(intToRoman(1994)).isEqualTo("MCMXCIV");
    }

    public String intToRoman(int num) {
        List<Roman> list = new ArrayList<>();
        list.add(new Roman(1000, "M"));
        list.add(new Roman(900, "CM"));
        list.add(new Roman(500, "D"));
        list.add(new Roman(400, "CD"));
        list.add(new Roman(100, "C"));
        list.add(new Roman(90, "XC"));
        list.add(new Roman(50, "L"));
        list.add(new Roman(40, "XL"));
        list.add(new Roman(10, "X"));
        list.add(new Roman(9, "IX"));
        list.add(new Roman(5, "V"));
        list.add(new Roman(4, "IV"));
        list.add(new Roman(1, "I"));
        StringBuilder sb = new StringBuilder();
        for (Roman roman : list) {
            num = roman.process(sb, num);
        }
        return sb.toString();
    }

    class Roman {
        int value;
        String symbol;

        public Roman(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }

        int process(StringBuilder sb, int n) {
            int cnt = n / value;
            for (int i = 0; i < cnt; i++) {
                sb.append(symbol);
            }
            return n % value;
        }
    }

}
