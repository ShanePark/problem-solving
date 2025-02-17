package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats87.75%
 */
public class Q1079LetterTilePossibilities2 {

    @Test
    public void test() {
        assertThat(numTilePossibilities("AAB")).isEqualTo(8);
        assertThat(numTilePossibilities("AAABBC")).isEqualTo(188);
        assertThat(numTilePossibilities("V")).isEqualTo(1);
    }

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return dfs(count);
    }

    private int dfs(int[] count) {
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0)
                continue;
            count[i]--;
            answer += (dfs(count) + 1);
            count[i]++;
        }
        return answer;
    }

}
