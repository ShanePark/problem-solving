package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1799MaximizeScoreAfterNOperations {

    @Test
    void test() {
        assertThat(maxScore(new int[]{1, 2})).isEqualTo(1);
        assertThat(maxScore(new int[]{3, 4, 6, 8})).isEqualTo(11);
        assertThat(maxScore(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(14);
    }

    /**
     * 642 ms
     */
    @Test
    void tle() {
        assertThat(maxScore(new int[]{984916, 312350, 779975, 165893, 436389, 592384, 264617, 136726, 8893, 587955, 921403, 891842})).isEqualTo(257);
    }

    @Test
    void testGcd() {
        assertThat(gcd(5, 7)).isEqualTo(1);
        assertThat(gcd(4, 6)).isEqualTo(2);
        assertThat(gcd(6, 12)).isEqualTo(6);
    }

    int max;

    public int maxScore(int[] nums) {
        max = 0;
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, 0, 0);
        return max;
    }

    private void dfs(int[] nums, boolean[] visited, int index, int sum) {
        if (index * 2 == nums.length)
            max = Math.max(max, sum);

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (visited[j])
                    continue;
                visited[j] = true;
                dfs(nums, visited, index + 1, sum + (index + 1) * gcd(nums[i], nums[j]));
                visited[j] = false;
            }
            visited[i] = false;
        }
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }

}
