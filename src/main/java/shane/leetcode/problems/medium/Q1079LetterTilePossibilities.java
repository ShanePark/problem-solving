package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1079LetterTilePossibilities {

    @Test
    public void test() {
        assertThat(numTilePossibilities("AAB")).isEqualTo(8);
        assertThat(numTilePossibilities("AAABBC")).isEqualTo(188);
        assertThat(numTilePossibilities("V")).isEqualTo(1);
    }

    int sum;

    public int numTilePossibilities(String tiles) {
        sum = 0;
        int[] arr = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            arr[tiles.charAt(i) - 'A']++;
        }
        dfs(arr);
        return sum;
    }

    private void dfs(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            dfs(arr);
            arr[i]++;
        }
    }
}
