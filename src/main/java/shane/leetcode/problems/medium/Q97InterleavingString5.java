package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q97InterleavingString5 {

    @Test
    public void test() {
        assertThat(isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
        assertThat(isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();
        assertThat(isInterleave("", "", "")).isTrue();
        assertThat(isInterleave("", "", "a")).isFalse();

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 + length2 != s3.length())
            return false;

        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= length1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
                continue;
            }
            break;
        }

        for (int j = 1; j <= length2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
                continue;
            }
            break;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (dp[i][j])
                    continue;
                char c3 = s3.charAt(i + j - 1);
                if (s1.charAt(i - 1) == c3) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == c3) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[length1][length2];
    }

}
