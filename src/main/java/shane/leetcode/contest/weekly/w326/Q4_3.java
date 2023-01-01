package shane.leetcode.contest.weekly.w326;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * with Sieve of Eratosthenes it finally passed
 */
public class Q4_3 {

    @Test
    public void test() {
        assertThat(closestPrimes(19, 31)).containsExactly(29, 31);
        assertThat(closestPrimes(710119, 710189)).containsExactly(710119, 710189);
        assertThat(closestPrimes(10, 19)).containsExactly(11, 13);
        assertThat(closestPrimes(4, 6)).containsExactly(-1, -1);
    }

    /**
     * 5 ms
     */
    @Test
    public void test2() {
        assertThat(closestPrimes(1, 1000000)).containsExactly(2, 3);
    }

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < right; i++) {
            int j = i;
            if (isPrime[j] == false)
                continue;
            while (j <= right) {
                if (i != j)
                    isPrime[j] = false;
                j += i;
            }
        }

        int[] answer = new int[]{-1, -1};
        int lastIndex = -1;
        int minLength = right - left + 1;

        while (left <= right) {
            if (isPrime[left]) {
                if (lastIndex != -1) {
                    if (left - lastIndex < minLength) {
                        minLength = left - lastIndex;
                        answer = new int[]{lastIndex, left};
                    }
                }
                lastIndex = left;
            }
            left++;
        }

        return answer;
    }

}
