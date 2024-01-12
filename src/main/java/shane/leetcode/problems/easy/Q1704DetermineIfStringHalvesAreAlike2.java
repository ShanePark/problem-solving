package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 9 ms Beats 25.54% of users with Java
 */
public class Q1704DetermineIfStringHalvesAreAlike2 {

    @Test
    public void test() {
        assertThat(halvesAreAlike("book")).isTrue();
        assertThat(halvesAreAlike("textbook")).isFalse();
    }

    public boolean halvesAreAlike(String s) {
        s = s.toUpperCase();
        int length = s.length();
        int cnt = 0;
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U');
        for (int i = 0; i < s.length() / 2; i++) {
            char c1 = s.charAt(i);
            if (vowels.contains(c1)) {
                cnt++;
            }
            char c2 = s.charAt(length / 2 + i);
            if (vowels.contains(c2)) {
                cnt--;
            }
        }
        return cnt == 0;
    }

}
