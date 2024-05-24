package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 81.78% of users with Java
 */
public class Q1255MaximumScoreWordsFormedByLetters2 {

    @Test
    public void test() {
        assertThat(maxScoreWords(
                new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}))
                .isEqualTo(23);
        assertThat(maxScoreWords(
                new String[]{"xxxz", "ax", "bx", "cx"},
                new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'},
                new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}))
                .isEqualTo(27);
        assertThat(maxScoreWords(
                new String[]{"leetcode"},
                new char[]{'l', 'e', 't', 'c', 'o', 'd'},
                new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}))
                .isEqualTo(0);
    }

    int max = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        max = 0;
        int[][] wordsArr = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            wordsArr[i] = toArr(words[i]);
        }
        int[] arr = new int[26];
        for (char letter : letters) {
            arr[letter - 'a']++;
        }
        backTracking(wordsArr, arr, score, 0, 0);
        return max;
    }

    private void backTracking(int[][] wordsArr, int[] left, int[] score, int index, int cur) {
        if (index == wordsArr.length) {
            max = Math.max(max, cur);
            return;
        }
        // skip
        backTracking(wordsArr, left, score, index + 1, cur);

        // take
        int[] word = wordsArr[index];
        boolean possible = true;
        int bonus = 0;
        for (int i = 0; i < 26; i++) {
            left[i] -= word[i];
            bonus += word[i] * score[i];
            if (left[i] < 0) {
                possible = false;
            }
        }
        if (possible) {
            backTracking(wordsArr, left, score, index + 1, cur + bonus);
        }
        // repair
        for (int i = 0; i < 26; i++) {
            left[i] += word[i];
        }
    }

    private int[] toArr(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }
        return arr;
    }

}
