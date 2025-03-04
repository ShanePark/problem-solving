package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 34ms
 * Beats7.85%
 */
public class Q1780CheckIfNumberIsASumOfPowersOfThree2 {

    @Test
    public void test() {
        assertThat(checkPowersOfThree(12)).isTrue();
        assertThat(checkPowersOfThree(91)).isTrue();
        assertThat(checkPowersOfThree(21)).isFalse();
        assertThat(checkPowersOfThree(0)).isFalse();
    }

    @Test
    public void tle() {
        assertThat(checkPowersOfThree(29781)).isFalse();
    }

    public boolean checkPowersOfThree(int n) {
        if (n == 0)
            return false;
        return dfs(n, 0);
    }

    private boolean dfs(int n, int index) {
        if (n == 0)
            return true;
        int pow = (int) Math.pow(3, index);
        if (n < pow)
            return false;
        if (dfs(n, index + 1))
            return true;
        return dfs(n - pow, index + 1);
    }

}
