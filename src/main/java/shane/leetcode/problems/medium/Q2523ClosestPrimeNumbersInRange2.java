package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 172ms
 * Beats23.60%
 */
public class Q2523ClosestPrimeNumbersInRange2 {

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
        boolean[] isNotPrime = new boolean[right + 1];
        double sqrt = Math.sqrt(right);
        for (int i = 2; i <= sqrt; i++) {
            for (int j = i; i * j <= right; j++) {
                isNotPrime[i * j] = true;
            }
        }
        isNotPrime[1] = true;

        Integer before = null;
        int[] answer = new int[]{-1, -1};
        for (int i = left; i <= right; i++) {
            if (isNotPrime[i])
                continue;
            Integer rememberBefore = before;
            before = i;

            if (rememberBefore == null) {
                before = i;
                continue;
            }
            if (i - rememberBefore <= 2)
                return new int[]{rememberBefore, i};
            if (answer[0] < 0) {
                answer = new int[]{rememberBefore, i};
                continue;
            }
            if (answer[1] - answer[0] <= i - rememberBefore) {
                continue;
            }
            answer = new int[]{rememberBefore, i};
        }
        return answer;
    }

}
