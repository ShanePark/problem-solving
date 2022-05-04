package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1880CheckIfWordEqualsSummationOfTwoWords {

    @Test
    public void test() {
        assertThat(isSumEqual("j", "j", "bi")).isTrue();
        assertThat(isSumEqual("acb", "cba", "cdb")).isTrue();
        assertThat(isSumEqual("aaa", "a", "aab"));
        assertThat(isSumEqual("aaa", "a", "aaaa")).isTrue();
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return num(firstWord) + num(secondWord) == num(targetWord);
    }

    private int num(String word) {
        int number = 0;
        for (int i = 0; i < word.length(); i++) {
            number = number * 10 + (word.charAt(i) - 'a');
        }
        return number;
    }
}
