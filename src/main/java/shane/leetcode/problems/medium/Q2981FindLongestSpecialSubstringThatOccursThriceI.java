package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6ms Beats72.29%
 */
public class Q2981FindLongestSpecialSubstringThatOccursThriceI {

    @Test
    public void test() {
        assertThat(maximumLength("aaaa")).isEqualTo(2);
        assertThat(maximumLength("abcdef")).isEqualTo(-1);
        assertThat(maximumLength("abcaba")).isEqualTo(1);
    }

    public int maximumLength(String s) {
        int[][] cntArr = new int[26][51];
        int length = 0;
        int before = ' ';
        for (char c : s.toCharArray()) {
            if (c == before) {
                length++;
            } else {
                before = c;
                length = 1;
            }
            cntArr[c - 'a'][length]++;
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            for (int j = 49; j > 0; j--) {
                cntArr[i][j] += cntArr[i][j + 1];
                if (cntArr[i][j] >= 3) {
                    max = Math.max(max, j);
                }
            }
        }

        return max;
    }

}
