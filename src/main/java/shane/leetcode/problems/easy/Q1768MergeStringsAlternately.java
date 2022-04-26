package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1768MergeStringsAlternately {

    @Test
    public void test() {
        assertThat(mergeAlternately("abc", "pqr")).isEqualTo("apbqcr");
        assertThat(mergeAlternately("ab", "pqrs")).isEqualTo("apbqrs");
        assertThat(mergeAlternately("ab", "a")).isEqualTo("aab");
        assertThat(mergeAlternately("a", "ab")).isEqualTo("aab");
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        String longer = (word1.length() > word2.length()) ? word1 : word2;
        sb.append(longer.substring(min));
        return sb.toString();
    }

}
