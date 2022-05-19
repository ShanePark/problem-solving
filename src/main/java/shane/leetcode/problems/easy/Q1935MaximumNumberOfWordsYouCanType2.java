package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1935MaximumNumberOfWordsYouCanType2 {

    @Test
    public void test() {
        assertThat(canBeTypedWords("hello world", "ad")).isEqualTo(1);
        assertThat(canBeTypedWords("leet code", "lt")).isEqualTo(1);
        assertThat(canBeTypedWords("leet code", "e")).isEqualTo(0);
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            broken[brokenLetters.charAt(i) - 'a'] = true;
        }

        String[] arr = text.split(" ");
        int cnt = arr.length;
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                if (broken[s.charAt(i) - 'a']) {
                    cnt--;
                    break;
                }
            }
        }

        return cnt;
    }

}
