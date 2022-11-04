package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 21 ms, faster than 26.11% of Java online submissions for Reverse Vowels of a String.
Memory Usage: 48.2 MB, less than 21.78% of Java online submissions for Reverse Vowels of a String.
 */
public class Q345ReverseVowelsOfAString {

    @Test
    public void test() {
        assertThat(reverseVowels("aA")).isEqualTo("Aa");
        assertThat(reverseVowels("hello")).isEqualTo("holle");
        assertThat(reverseVowels("leetcode")).isEqualTo("leotcede");
    }

    public String reverseVowels(String s) {
        final Set<Character> VOWEL = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        Queue<Character> vowels = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (VOWEL.contains(c)) {
                vowels.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (VOWEL.contains(c)) {
                sb.append(vowels.poll());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
