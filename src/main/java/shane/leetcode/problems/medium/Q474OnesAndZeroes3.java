package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("ALL")
public class Q474OnesAndZeroes3 {

    @Test
    public void test() {
        assertThat(findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3)).isEqualTo(3);
        assertThat(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)).isEqualTo(4);
        assertThat(findMaxForm(new String[]{"10", "0", "1"}, 1, 1)).isEqualTo(2);
        assertThat(findMaxForm(new String[]{"11", "11", "0", "0", "10", "1", "1", "0", "11", "1", "0", "111", "11111000", "0", "11", "000", "1", "1", "0", "00", "1", "101", "001", "000", "0", "00", "0011", "0", "10000"},
                90, 66)).isEqualTo(29);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (String str : strs) {
            int cnt0 = 0;
            int cnt1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
            for (int i = m; i >= cnt0; i--) {
                for (int j = n; j >= cnt1; j--) {
                    memo[i][j] = Math.max(1 + memo[i - cnt0][j - cnt1], memo[i][j]);
                }
            }
        }
        return memo[m][n];
    }

}
