package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 66.65% of users with Java
 */
public class Q409LongestPalindrome {

    @Test
    public void test() {
        assertThat(longestPalindrome("abccccdd")).isEqualTo(7);
        assertThat(longestPalindrome("a")).isEqualTo(1);
        assertThat(longestPalindrome("aacc")).isEqualTo(4);
        assertThat(longestPalindrome("aacd")).isEqualTo(3);
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        int answer = 0;
        for (Integer i : cnt.values()) {
            answer += (i / 2) * 2;
        }
        return Math.min(s.length(), answer + 1);
    }

}
