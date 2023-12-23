package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 5ms Beats 42.95%of users with Java
 * Memory Details 42.11MB Beats 6.17%of users with Java
 */
public class Q1496PathCrossing {

    @Test
    public void test() {
        assertThat(isPathCrossing("NES")).isFalse();
        assertThat(isPathCrossing("NESWW")).isTrue();
    }

    public boolean isPathCrossing(String path) {
        int y = 0;
        int x = 0;
        Set<String> visited = new HashSet<>();
        visited.add(y + " " + x);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if (!visited.add(y + " " + x)) {
                return true;
            }
        }
        return false;
    }

}
