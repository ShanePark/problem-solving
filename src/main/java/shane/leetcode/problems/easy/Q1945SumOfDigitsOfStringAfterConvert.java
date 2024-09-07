package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats88.60%
 */
public class Q1945SumOfDigitsOfStringAfterConvert {

    @Test
    public void test() {
        assertThat(getLucky("iiii", 1)).isEqualTo(36);
        assertThat(getLucky("leetcode", 2)).isEqualTo(6);
        assertThat(getLucky("zbax", 2)).isEqualTo(8);
    }

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            sb.append(num);
        }
        int sum = toNumber(sb.toString());
        while (--k > 0) {
            sum = toNumber(String.valueOf(sum));
        }
        return sum;
    }

    private static int toNumber(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

}
