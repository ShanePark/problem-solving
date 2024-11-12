package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 18ms Beats7.89%
 */
public class Q2601PrimeSubtractionOperation {

    @Test
    public void test() {
        assertThat(primeSubOperation(new int[]{998, 2})).isTrue();
        assertThat(primeSubOperation(new int[]{5, 8, 3})).isFalse();
        assertThat(primeSubOperation(new int[]{6, 8, 11, 12})).isTrue();
        assertThat(primeSubOperation(new int[]{4, 9, 6, 10})).isTrue();
    }

    public boolean primeSubOperation(int[] nums) {
        final List<Integer> primes = findPrimes(1000);
        int min = Integer.MIN_VALUE;
        for (int num : nums) {
            num = minAfterOperation(primes, num, min);
            if (num <= min)
                return false;
            min = num;
        }
        return true;
    }

    private List<Integer> findPrimes(int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isPrime(int n) {
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private int minAfterOperation(List<Integer> primes, int num, int min) {
        int curMin = num;
        for (Integer prime : primes) {
            int sub = num - prime;
            if (sub <= 0 || sub <= min)
                return curMin;
            curMin = sub;
        }
        return curMin;
    }

}
