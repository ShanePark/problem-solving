package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 31 ms Beats 64.29% of users with Java
 */
public class Q2370LongestIdealSubsequence2 {

    @Test
    public void test() {
        assertThat(longestIdealString("acfgdb", 2)).isEqualTo(4);
        assertThat(longestIdealString("abcd", 3)).isEqualTo(4);
        assertThat(longestIdealString("lkpkxcigcs", 6)).isEqualTo(7);
    }

    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (char cur : s.toCharArray()) {
            int curIndex = cur - 'a';
            dp[curIndex] = dp[curIndex] == 0 ? 1 : dp[curIndex] + 1;
            for (int i = Math.max(0, curIndex - k); i <= Math.min(25, curIndex + k); i++) {
                if (i == curIndex || dp[i] == 0)
                    continue;
                dp[curIndex] = Math.max(dp[curIndex], dp[i] + 1);
            }

        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
