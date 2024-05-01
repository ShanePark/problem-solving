package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q2000ReversePrefixOfWord2 {

    @Test
    public void test() {
        assertThat(reversePrefix("abcdefd", 'd')).isEqualTo("dcbaefd");
        assertThat(reversePrefix("xyxzxe", 'z')).isEqualTo("zxyxxe");
        assertThat(reversePrefix("abcd", 'z')).isEqualTo("abcd");
    }

    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c);
            if (c == ch) {
                sb.reverse();
                ch = ' ';
            }
        }

        return sb.toString();
    }

}
