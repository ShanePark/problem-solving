package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2108FindFirstPalindromicStringInTheArray2 {

    @Test
    public void test() {
        assertThat(firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"})).isEqualTo("ada");
        assertThat(firstPalindrome(new String[]{"notapalindrome", "racecar"})).isEqualTo("racecar");
        assertThat(firstPalindrome(new String[]{"def", "ghi"})).isEqualTo("");
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int LENGTH = word.length();
        for (int i = 0; i < LENGTH / 2; i++) {
            if (word.charAt(i) != word.charAt(LENGTH - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
