package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4
 * ms
 * Beats
 * 90.05%
 */
public class Q1513NumberOfSubstringsWithOnly1s {

    @Test
    public void test() {
        assertThat(numSub("0110111")).isEqualTo(9);
        assertThat(numSub("101")).isEqualTo(2);
        assertThat(numSub("111111")).isEqualTo(21);
    }


    final int MOD = (int) 1e9 + 7;

    public int numSub(String s) {
        int answer = 0;
        int length = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                length++;
                continue;
            }
            long cur = (long) length * (length + 1) / 2;
            answer = (int) ((cur + answer) % MOD);
            length = 0;
        }
        long cur = (long) length * (length + 1) / 2;
        return (int) ((cur + answer) % MOD);
    }

}
