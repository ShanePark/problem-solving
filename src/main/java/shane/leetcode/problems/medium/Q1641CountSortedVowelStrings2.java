package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1641CountSortedVowelStrings2 {

    @Test
    public void test() {
        assertThat(countVowelStrings(1)).isEqualTo(5);
        assertThat(countVowelStrings(2)).isEqualTo(15);
        assertThat(countVowelStrings(3)).isEqualTo(35);
        assertThat(countVowelStrings(33)).isEqualTo(66045);
    }

    public int countVowelStrings(int n) {
        int[] memo = {1, 1, 1, 1, 1};
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    memo[j] += memo[k];
                }
            }
        }
        return memo[0] + memo[1] + memo[2] + memo[3] + memo[4];
    }
}
