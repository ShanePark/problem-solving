package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 129 ms, faster than 66.84% of Java online submissions for Longest Palindrome by Concatenating Two Letter Words.
 * Memory Usage: 57.6 MB, less than 96.51% of Java online submissions for Longest Palindrome by Concatenating Two Letter Words.
 */
public class Q2131LongestPalindromeByConcatenatingTwoLetterWords {

    @Test
    public void test() {
        assertThat(longestPalindrome(new String[]{"bb", "bb"})).isEqualTo(4);
        assertThat(longestPalindrome(new String[]{"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"})).isEqualTo(14);
        assertThat(longestPalindrome(new String[]{"mm", "mm", "yb", "by", "bb", "bm", "ym", "mb", "yb", "by", "mb", "mb", "bb", "yb", "by", "bb", "yb", "my", "mb", "ym"})).isEqualTo(30);
        assertThat(longestPalindrome(new String[]{"lc", "cl", "gg"})).isEqualTo(6);
        assertThat(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"})).isEqualTo(8);
        assertThat(longestPalindrome(new String[]{"cc", "ll", "xx"})).isEqualTo(2);

    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (String word : words) {
            String reverse = word.charAt(1) + "" + word.charAt(0);
            if (map.containsKey(reverse)) {
                cnt++;
                Integer after = map.merge(reverse, -1, Integer::sum);
                if (after == 0)
                    map.remove(reverse);
            } else {
                map.merge(word, 1, Integer::sum);
            }
        }
        boolean hasCenter = map.keySet().stream()
                .filter(s -> s.charAt(0) == s.charAt(1))
                .findAny()
                .isPresent();

        return (hasCenter ? 2 : 0) + cnt * 4;
    }
}
