package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q583DeleteOperationForTwoStrings3 {

    @Test
    public void test() {
        assertThat(minDistance("mart", "karma")).isEqualTo(5);
        assertThat(minDistance("pvhvykrvntdywrhylaprgqmbzqitrhdmxboyw", "oelftlrthdmlwznwuritwrvdciho")).isEqualTo(45);
        assertThat(minDistance("plasma", "altruism")).isEqualTo(8);
        assertThat(minDistance("park", "spake")).isEqualTo(3);
        assertThat(minDistance("a", "b")).isEqualTo(2);
        assertThat(minDistance("sea", "ate")).isEqualTo(4);
        assertThat(minDistance("sea", "eat")).isEqualTo(2);
        assertThat(minDistance("leetcode", "etco")).isEqualTo(4);
    }

    public int minDistance(String word1, String word2) {
        int[][] memo = new int[500][500];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return minDistance(word1, word2, 0, 0, memo);

    }

    private int minDistance(String word1, String word2, int i1, int i2, int[][] memo) {
        if (i1 == word1.length()) {
            return word2.length() - i2;
        }
        if (i2 == word2.length()) {
            return word1.length() - i1;
        }
        if (memo[i1][i2] != -1)
            return memo[i1][i2];

        if (word1.charAt(i1) == word2.charAt(i2)) {
            memo[i1][i2] = minDistance(word1, word2, i1 + 1, i2 + 1, memo);
        } else {
            memo[i1][i2] = 1 + Math.min(minDistance(word1, word2, i1 + 1, i2, memo), minDistance(word1, word2, i1, i2 + 1, memo));
        }
        return memo[i1][i2];
    }
}

