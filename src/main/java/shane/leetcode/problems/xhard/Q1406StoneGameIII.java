package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 92 ms Beats 14.57%
 * Memory 64.8 MB Beats 5.3%
 */
public class Q1406StoneGameIII {

    @Test
    void test() {
        assertThat(stoneGameIII(new int[]{1, 2, 3, 7})).isEqualTo("Bob");
        assertThat(stoneGameIII(new int[]{1, 2, 3, -9})).isEqualTo("Alice");
        assertThat(stoneGameIII(new int[]{1, 2, 3, 6})).isEqualTo("Tie");
        assertThat(stoneGameIII(new int[]{1})).isEqualTo("Alice");
        assertThat(stoneGameIII(new int[]{1, 2})).isEqualTo("Alice");
        assertThat(stoneGameIII(new int[]{1, 2, 3})).isEqualTo("Alice");
    }

    public String stoneGameIII(int[] stoneValue) {
        Integer[] dp = new Integer[stoneValue.length];
        int result = play(stoneValue, 0, dp);
        if (result > 0) {
            return "Alice";
        }
        if (result < 0)
            return "Bob";
        return "Tie";
    }

    private int play(int[] stoneValue, int index, Integer[] dp) {
        if (index >= stoneValue.length)
            return 0;
        if (dp[index] != null) {
            return dp[index];
        }

        int myScore = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < 3 && index + i < stoneValue.length; i++) {
            myScore += stoneValue[index + i];
            int enemy = play(stoneValue, index + i + 1, dp);
            maxScore = Math.max(maxScore, myScore - enemy);
        }

        return dp[index] = maxScore;
    }

}
