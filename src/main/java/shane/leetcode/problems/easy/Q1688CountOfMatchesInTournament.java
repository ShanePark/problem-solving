package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 39.87MB Beats 8.36%of users with Java
 */
public class Q1688CountOfMatchesInTournament {

    @Test
    public void test() {
        assertThat(numberOfMatches(7)).isEqualTo(6);
        assertThat(numberOfMatches(14)).isEqualTo(13);
    }

    public int numberOfMatches(int n) {
        return n-1;
    }

}
