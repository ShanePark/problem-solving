package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2523ClosestPrimeNumbersInRange {

    @Test
    public void test() {
        assertThat(closestPrimes(10, 19)).isEqualTo(new int[]{11, 13});
        assertThat(closestPrimes(4, 6)).isEqualTo(new int[]{-1, -1});
        assertThat(closestPrimes(19, 31)).isEqualTo(new int[]{29, 31});
        assertThat(closestPrimes(1, 1000000)).isEqualTo(new int[]{2, 3});
    }

    @Test
    public void tle() {
        assertThat(closestPrimes(850350, 851803)).isEqualTo(new int[]{851801, 851803});
    }

    public int[] closestPrimes(int left, int right) {
        Set<Integer> primes = new HashSet<>();
        for (int i = left; i <= right; i++) {
            primes.add(i);
        }
        primes.remove(1);
        double sqrt = Math.sqrt(right);
        for (int i = 2; i <= sqrt; i++) {
            for (int j = 2; i * j <= right; j++) {
                primes.remove(i * j);
            }
        }

        List<Integer> sortedPrimes = primes.stream().sorted().collect(Collectors.toList());
        Integer before = null;
        int[] answer = new int[]{-1, -1};
        for (Integer prime : sortedPrimes) {
            if (before == null) {
                before = prime;
                continue;
            }
            if (answer[0] < 0) {
                answer = new int[]{before, prime};
                before = prime;
                continue;
            }
            if (answer[1] - answer[0] <= prime - before) {
                before = prime;
                continue;
            }
            answer = new int[]{before, prime};
            before = prime;
        }
        return answer;
    }

}
