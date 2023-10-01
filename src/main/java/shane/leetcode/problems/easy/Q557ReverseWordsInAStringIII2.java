package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Java Runtime 10 ms Beats 39.98%
 * Memory 43.4 MB Beats 99.68%
 */
public class Q557ReverseWordsInAStringIII2 {

    @Test
    public void test() {
        assertThat(reverseWords("Let's take LeetCode contest")).isEqualTo("s'teL ekat edoCteeL tsetnoc");
        assertThat(reverseWords("God Ding")).isEqualTo("doG gniD");
        assertThat(reverseWords("a")).isEqualTo("a");
    }

    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(sb).append(c);
                sb = new StringBuilder();
                continue;
            }
            sb.insert(0, c);
        }
        answer.append(sb);
        return answer.toString();
    }

}
