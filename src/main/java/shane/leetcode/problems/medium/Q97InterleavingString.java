package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q97InterleavingString {

    @Test
    public void test() {
        assertThat(isInterleave("c", "ca", "cac")).isTrue();
        assertThat(isInterleave("aabcc", "dbbca", "aadbcbbcac")).isTrue();
        assertThat(isInterleave("a", "b", "a")).isFalse();
        assertThat(isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
        assertThat(isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();
        assertThat(isInterleave("", "", "")).isTrue();
    }

    @Test
    public void test2() {
        // 7 Sec 631 ms
        assertThat(isInterleave(
                "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc",
                "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb",
                "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"))
                .isTrue();
    }

    @Test
    public void test3() {
        // 4s 884 ms
        assertThat(isInterleave(
                "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"))
                .isFalse();
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int p1 = 0, p2 = 0, p3 = 0;
        while (p3 < s3.length()) {
            if (p1 < s1.length() && p2 < s2.length() && s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3)) {
                // try both
                boolean b1 = isInterleave(s1.substring(p1 + 1), s2.substring(p2), s3.substring(p3 + 1));
                boolean b2 = isInterleave(s1.substring(p1), s2.substring(p2 + 1), s3.substring(p3 + 1));
                return (b1 || b2);
            } else if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
                p1++;
            } else if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
                p2++;
            } else {
                return false;
            }
            p3++;
        }

        return true;
    }


}
