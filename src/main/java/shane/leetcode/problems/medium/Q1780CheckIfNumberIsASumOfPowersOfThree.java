package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1780CheckIfNumberIsASumOfPowersOfThree {

    @Test
    public void test() {
        assertThat(checkPowersOfThree(12)).isTrue();
        assertThat(checkPowersOfThree(91)).isTrue();
        assertThat(checkPowersOfThree(21)).isFalse();
    }

    @Test
    public void tle() {
        assertThat(checkPowersOfThree(29781)).isFalse();
    }

    public boolean checkPowersOfThree(int n) {
        Set<Integer> powers = new LinkedHashSet<>();
        int p = 1;
        powers.add(1);
        while (p <= n) {
            p *= 3;
            powers.add(p);
        }
        return checkPowersOfThree(n, powers, new HashSet<>());
    }

    private boolean checkPowersOfThree(int n, Set<Integer> powers, Set<Integer> visited) {
        if (n == 0)
            return true;
        for (int power : powers) {
            if (n < power)
                break;
            if (!visited.add(power))
                continue;
            if (checkPowersOfThree(n - power, powers, visited))
                return true;
            visited.remove(power);
        }
        return false;
    }

}
