package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 1sec 31ms
 */
@SuppressWarnings("ALL")
public class Q97InterleavingString2 {

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

    public boolean isInterleave(String s1, String s2, String s3) {
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
        return check(s1, s2, s3, 0, 0, 0);
    }

    public boolean check(String s1, String s2, String s3, int p1, int p2, int p3) {
        while (p3 < s3.length()) {
            if (p1 < s1.length() && p2 < s2.length() && s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3)) {
                // try both
                return check(s1, s2, s3, p1 + 1, p2, p3 + 1) || check(s1, s2, s3, p1, p2 + 1, p3 + 1);
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
