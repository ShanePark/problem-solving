package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2000ReversePrefixOfWord {

    @Test
    public void test() {
        assertThat(reversePrefix("abcdefd", 'd')).isEqualTo("dcbaefd");
        assertThat(reversePrefix("xyxzxe", 'z')).isEqualTo("zxyxxe");
        assertThat(reversePrefix("abcd", 'z')).isEqualTo("abcd");
        assertThat(reversePrefix("abcd", 'd')).isEqualTo("dcba");
        assertThat(reversePrefix("a", 'a')).isEqualTo("a");
    }

    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i < 0)
            return word;
        StringBuilder sb = new StringBuilder();
        for (int j = i; j >= 0; j--) {
            sb.append(word.charAt(j));
        }
        return sb + word.substring(i + 1);
    }
}
