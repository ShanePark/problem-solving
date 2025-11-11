package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("ALL")
public class Q474OnesAndZeroes4 {

    @Test
    public void test() {
        assertThat(findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3)).isEqualTo(3);
        assertThat(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)).isEqualTo(4);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroCnt = 0;
            int oneCnt = 0;
            for (char c : str.toCharArray())
                if (c == '0') zeroCnt++;
                else oneCnt++;
            for (int i = m; i >= zeroCnt; i--)
                for (int j = n; j >= oneCnt; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCnt][j - oneCnt] + 1);
        }
        return dp[m][n];
    }

}
