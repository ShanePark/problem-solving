package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7ms Beats59.23% 
 */
public class Q2559CountVowelStringsInRanges {

    @Test
    public void test() {
        assertThat(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}})).isEqualTo(new int[]{2, 3, 0});
        assertThat(vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}})).isEqualTo(new int[]{3, 2, 1});
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        final int LENGTH = words.length;
        int[] vowelWords = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            if (isVowel(first) && isVowel(last)) {
                vowelWords[i] = 1;
            }
        }
        int[] sumArr = new int[LENGTH];
        sumArr[0] = vowelWords[0];
        for (int i = 1; i < LENGTH; i++) {
            sumArr[i] = sumArr[i - 1] + vowelWords[i];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            answer[i] = sumArr[end] - (start == 0 ? 0 : sumArr[start - 1]);
        }
        return answer;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
