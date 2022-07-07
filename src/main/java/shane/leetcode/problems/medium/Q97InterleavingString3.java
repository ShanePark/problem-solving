package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q97InterleavingString3 {

    @Test
    public void test() {
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
        assertThat(isInterleave("aabcc", "dbbca", "aadbcbbcac")).isTrue();
        assertThat(isInterleave("a", "b", "a")).isFalse();
        assertThat(isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
        assertThat(isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();
        assertThat(isInterleave("", "", "")).isTrue();
    }

    short[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s3.length(); i++) {
            arr[s3.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0)
                return false;
        }
        dp = new short[101][101];
        return check(s1, s2, s3, 0, 0);
    }

    public boolean check(String s1, String s2, String s3, int p1, int p2) {
        if (p1 + p2 == s3.length())
            return true;
        if (dp[p1][p2] == 1)
            return true;
        if (dp[p1][p2] == -1)
            return false;
        if (p1 < s1.length() && p2 < s2.length() && s1.charAt(p1) == s3.charAt(p1 + p2) && s2.charAt(p2) == s3.charAt(p1 + p2)) {
            return ((dp[p1 + 1][p2] == 0) ? check(s1, s2, s3, p1 + 1, p2) : dp[p1 + 1][p2] == 1)
                    || ((dp[p1][p2 + 1] == 0) ? check(s1, s2, s3, p1, p2 + 1) : dp[p1][p2 + 1] == 1);
        } else if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p1 + p2)) {
            return check(s1, s2, s3, p1 + 1, p2);
        } else if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p1 + p2)) {
            return check(s1, s2, s3, p1, p2 + 1);
        } else {
            dp[p1][p2] = -1;
            return false;
        }
    }
}
