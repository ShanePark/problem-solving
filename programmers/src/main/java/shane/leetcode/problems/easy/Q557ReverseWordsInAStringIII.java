package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q557ReverseWordsInAStringIII {

    @Test
    public void test() {
        assertThat(reverseWords("Let's take LeetCode contest")).isEqualTo("s'teL ekat edoCteeL tsetnoc");
        assertThat(reverseWords("God Ding")).isEqualTo("doG gniD");
        assertThat(reverseWords("a")).isEqualTo("a");
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (String str : arr) {
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
