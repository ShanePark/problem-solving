package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q97InterleavingString4 {

    @Test
    public void test() {
        assertThat(isInterleave("c", "ca", "cac")).isTrue();
        assertThat(isInterleave("aabcc", "dbbca", "aadbcbbcac")).isTrue();
        assertThat(isInterleave("a", "b", "a")).isFalse();
        assertThat(isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
        assertThat(isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();
        assertThat(isInterleave("", "", "")).isTrue();
        assertThat(isInterleave(
                "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"))
                .isFalse();
        assertThat(isInterleave(
                "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc",
                "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb",
                "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"))
                .isTrue();
        assertThat(isInterleave(
                "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbb",
                "cbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcb",
                "cbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbb"))
                .isTrue();
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        final int length1 = s1.length();
        final int length2 = s2.length();
        if (length1 + length2 != s3.length())
            return false;

        boolean[][] dp = new boolean[101][101];
        dp[0][0] = true;
        for (int p1 = 0; p1 <= length1; p1++) {
            for (int p2 = 0; p2 <= length2; p2++) {
                if (p1 == 0 && p2 == 0) continue;
                char next = s3.charAt(p1 + p2 - 1);
                if (p1 == 0) {
                    dp[0][p2] = dp[0][p2 - 1] && (s2.charAt(p2 - 1) == next);
                } else if (p2 == 0) {
                    dp[p1][0] = dp[p1 - 1][0] && (s1.charAt(p1 - 1) == next);
                } else {
                    dp[p1][p2] = (dp[p1][p2 - 1] && (s2.charAt(p2 - 1) == next)) || (dp[p1 - 1][p2] && (s1.charAt(p1 - 1) == next));
                }
            }
        }
        return dp[length1][length2];
    }

}
