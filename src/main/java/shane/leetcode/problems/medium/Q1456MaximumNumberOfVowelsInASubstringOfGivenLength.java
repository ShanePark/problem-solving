package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 27 ms Beats 36.34%
 * Memory 43.1 MB Beats 54.76%
 */
public class Q1456MaximumNumberOfVowelsInASubstringOfGivenLength {

    @Test
    void test() {
        assertThat(maxVowels("abciiidef", 3)).isEqualTo(3);
        assertThat(maxVowels("aeiou", 2)).isEqualTo(2);
        assertThat(maxVowels("leetcode", 3)).isEqualTo(2);
        assertThat(maxVowels("a", 1)).isEqualTo(1);
        assertThat(maxVowels("d", 1)).isEqualTo(0);
    }

    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                cnt++;
            }
        }
        int max = cnt;
        for (int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            char remove = s.charAt(i - k);
            if (vowels.contains(remove)) {
                cnt--;
            }
            if (vowels.contains(c)) {
                cnt++;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

}
