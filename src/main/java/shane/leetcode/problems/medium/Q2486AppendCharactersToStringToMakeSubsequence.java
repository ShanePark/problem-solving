package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 92.09% of users with Java
 */
public class Q2486AppendCharactersToStringToMakeSubsequence {

    @Test
    public void test() {
        assertThat(appendCharacters("coaching", "coding")).isEqualTo(4);
        assertThat(appendCharacters("abcde", "a")).isEqualTo(0);
        assertThat(appendCharacters("z", "abcde")).isEqualTo(5);
    }

    public int appendCharacters(String s, String t) {
        int index = 0;
        for (char c : s.toCharArray()) {
            if (t.charAt(index) == c) {
                index++;
            }
            if (index == t.length())
                return 0;
        }
        return t.length() - index;
    }

}
