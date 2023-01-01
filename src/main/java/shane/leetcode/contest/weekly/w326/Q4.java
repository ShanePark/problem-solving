package shane.leetcode.contest.weekly.w326;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q4 {

    @Test
    public void test() {
        assertThat(closestPrimes(19, 31)).containsExactly(29, 31);
        assertThat(closestPrimes(10, 19)).containsExactly(11, 13);
        assertThat(closestPrimes(4, 6)).containsExactly(-1, -1);
    }

    /**
     * 100 ms
     */
    @Test
    public void test2() {
        assertThat(closestPrimes(1, 1000000)).containsExactly(2, 3);
    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        while (left <= right) {
            if (isPrime(left)) {
                primes.add(left);
            }
            left++;
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int min = primes.get(1) - primes.get(0);
        int[] answer = new int[]{primes.get(0), primes.get(1)};
        for (int i = 1; i < primes.size() - 1; i++) {
            int gap = primes.get(i + 1) - primes.get(i);
            if (gap < min) {
                min = gap;
                answer = new int[]{primes.get(i), primes.get(i + 1)};
            }
        }

        return answer;
    }

    private boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
