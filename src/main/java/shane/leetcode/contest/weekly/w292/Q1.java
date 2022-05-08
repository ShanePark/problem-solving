package shane.leetcode.contest.weekly.w292;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(largestGoodInteger("6777133339")).isEqualTo("777");
        assertThat(largestGoodInteger("2300019")).isEqualTo("000");
        assertThat(largestGoodInteger("42352338")).isEqualTo("");
    }

    public String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        String maxString = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String str = num.substring(i, i + 3);
                int integer = Integer.parseInt(str);
                if (max < integer) {
                    max = integer;
                    maxString = str;
                }
            }
        }

        return maxString;
    }

}
