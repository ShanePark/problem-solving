package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 47
 * ms
 * Beats
 * 85.37%
 */
public class Q2131LongestPalindromeByConcatenatingTwoLetterWords2 {

    @Test
    public void test() {
        assertThat(longestPalindrome(new String[]{"lc", "cl", "gg"})).isEqualTo(6);
        assertThat(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"})).isEqualTo(8);
        assertThat(longestPalindrome(new String[]{"cc", "ll", "xx"})).isEqualTo(2);
        assertThat(longestPalindrome(new String[]{"aa", "aa"})).isEqualTo(4);
        assertThat(longestPalindrome(new String[]{"ab", "ad"})).isEqualTo(0);

    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.merge(word, 1, Integer::sum);
        }
        int sum = 0;
        boolean hasOddSame = false;
        for (String key : cnt.keySet()) {
            int count = cnt.get(key);
            if (count == 0)
                continue;
            if (key.charAt(0) == key.charAt(1)) {
                sum += (count - count % 2) * 2;
                if (count % 2 == 1)
                    hasOddSame = true;
                continue;
            }
            String reverse = key.charAt(1) + "" + key.charAt(0);
            int reverseCnt = cnt.getOrDefault(reverse, 0);
            if (reverseCnt == 0)
                continue;
            sum += 2 * Math.min(count, reverseCnt);
        }
        return sum + (hasOddSame ? 2 : 0);
    }

}
