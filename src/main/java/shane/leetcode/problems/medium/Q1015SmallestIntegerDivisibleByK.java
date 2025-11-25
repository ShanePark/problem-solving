package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
9ms
Beats7.59%
 */
public class Q1015SmallestIntegerDivisibleByK {

    @Test
    public void test() {
        assertThat(smallestRepunitDivByK(1)).isEqualTo(1);
        assertThat(smallestRepunitDivByK(2)).isEqualTo(-1);
        assertThat(smallestRepunitDivByK(3)).isEqualTo(3);
        assertThat(smallestRepunitDivByK(17)).isEqualTo(16);
    }

    public int smallestRepunitDivByK(int k) {
        int n = 1;
        int cnt = 1;
        Set<Integer> visited = new HashSet<>();
        while (n % k > 0) {
            if (!visited.add(n)) {
                return -1;
            }
            n = n * 10 + 1;
            n = n % k;
            cnt++;
        }
        return cnt;
    }

}
