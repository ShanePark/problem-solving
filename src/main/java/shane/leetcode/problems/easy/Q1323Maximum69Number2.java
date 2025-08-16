package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q1323Maximum69Number2 {

    @Test
    public void test() {
        assertThat(maximum69Number(9669)).isEqualTo(9969);
        assertThat(maximum69Number(9996)).isEqualTo(9999);
    }

    public int maximum69Number(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                break;
            }

        }
        return Integer.parseInt(sb.toString());
    }

}
