package shane.leetcode.contest.weekly.w298;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2309GreatestEnglishLetterInUpperAndLowerCase {

    @Test
    public void test() {
        assertThat(greatestLetter("lEeTcOdE")).isEqualTo("E");
        assertThat(greatestLetter("arRAzFif")).isEqualTo("R");
        assertThat(greatestLetter("AbCdEfGhIjK")).isEqualTo("");
    }

    public String greatestLetter(String s) {
        boolean[] small = new boolean[26];
        boolean[] capital = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                small[c - 'a'] = true;
            } else {
                capital[c - 'A'] = true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (small[i] && capital[i]) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }

}
