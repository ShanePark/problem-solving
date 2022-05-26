package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1255MaximumScoreWordsFormedByLetters {

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

    int maxScore;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore = 0;

        int[] letterCounts = countWords(new String(letters));
        dfs(words, letterCounts, score, 0, 0);
        return maxScore;
    }

    private void dfs(String[] words, int[] letterCounts, int[] score, int i, int point) {
        if (i == words.length) {
            maxScore = Math.max(maxScore, point);
            return;
        }

        // skip
        dfs(words, letterCounts, score, i + 1, point);

        // include
        String word = words[i];
        int[] wordCount = countWords(word);
        for (int j = 0; j < 26; j++) {
            wordCount[j] = letterCounts[j] - wordCount[j];
            if (wordCount[j] < 0)
                return;
        }
        dfs(words, wordCount, score, i + 1, point + calcPoint(word, score));
    }

    private int calcPoint(String word, int[] score) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += score[word.charAt(i) - 'a'];
        }
        return sum;
    }

    private int[] countWords(CharSequence word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        return arr;
    }

}
