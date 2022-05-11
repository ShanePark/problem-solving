package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1529MinimumSuffixFlips {

    @Test
    public void test() {
        assertThat(minFlips("10111")).isEqualTo(3);
        assertThat(minFlips("101")).isEqualTo(3);
        assertThat(minFlips("00000")).isEqualTo(0);
        assertThat(minFlips("1001")).isEqualTo(3);
    }

    public int minFlips(String target) {
        char c = '0';
        int cnt = 0;
        for (int i = 0; i < target.length(); i++) {
            if (c != target.charAt(i)) {
                cnt++;
                c = target.charAt(i);
            }
        }
        return cnt;
    }
}
