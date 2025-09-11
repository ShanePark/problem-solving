package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 79ms
 * Beats24.01%
 */
public class Q2785SortVowelsInAString2 {

    @Test
    public void test() {
        assertThat(sortVowels("lEetcOde")).isEqualTo("lEOtcede");
        assertThat(sortVowels("lYmpH")).isEqualTo("lYmpH");
    }

    public String sortVowels(String s) {
        Queue<Integer> indexes = new LinkedList<>();
        PriorityQueue<Character> vowels = new PriorityQueue<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                indexes.offer(i);
                vowels.offer(c);
            }
        }
        while (!indexes.isEmpty()) {
            arr[indexes.poll()] = vowels.poll();
        }
        return String.valueOf(arr);
    }

    private boolean isVowel(char c) {
        char lower = Character.toLowerCase(c);
        switch (lower) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

}
