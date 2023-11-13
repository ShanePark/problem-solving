package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2785SortVowelsInAString {

    @Test
    public void test() {
        assertThat(sortVowels("lEetcOde")).isEqualTo("lEOtcede");
        assertThat(sortVowels("lYmpH")).isEqualTo("lYmpH");
    }

    public String sortVowels(String s) {
        Queue<Character> vowels = new PriorityQueue<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append(vowels.poll());
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        switch (Character.toUpperCase(c)) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

}
