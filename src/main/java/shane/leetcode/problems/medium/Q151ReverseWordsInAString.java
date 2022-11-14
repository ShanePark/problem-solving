package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 22 ms Beats 35.60%
 * Memory 44.6 MB Beats 35%
 */
public class Q151ReverseWordsInAString {

    @Test
    public void test() {
        assertThat(reverseWords("the sky is blue")).isEqualTo("blue is sky the");
        assertThat(reverseWords("  hello world!  ")).isEqualTo("world! hello");
        assertThat(reverseWords("a good   example")).isEqualTo("example good a");
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            if (str.length() == 0)
                continue;
            sb.insert(0, str + " ");
        }
        return sb.toString().trim();
    }

}
