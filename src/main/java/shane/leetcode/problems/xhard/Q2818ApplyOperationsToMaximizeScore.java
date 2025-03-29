package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2818ApplyOperationsToMaximizeScore {

    @Test
    public void test() {
        assertThat(maximumScore(List.of(8, 3, 9, 3, 8), 2)).isEqualTo(81);
        assertThat(maximumScore(List.of(19, 12, 14, 6, 10, 18), 3)).isEqualTo(4788);
    }

    private static final int MOD = (int) 1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int[] primeScores = calcPrimeScores(nums);

        int[] nextDominant = new int[nums.size()];
        int[] prevDominant = new int[nums.size()];
        Arrays.fill(nextDominant, nums.size());
        Arrays.fill(prevDominant, -1);

        Stack<Integer> decreasingPrimeScoreStack = new Stack<>();
        for (int index = 0; index < nums.size(); index++) {
            while (!decreasingPrimeScoreStack.isEmpty() && primeScores[decreasingPrimeScoreStack.peek()] < primeScores[index]) {
                int topIndex = decreasingPrimeScoreStack.pop();
                nextDominant[topIndex] = index;
            }

            if (!decreasingPrimeScoreStack.isEmpty()) {
                prevDominant[index] = decreasingPrimeScoreStack.peek();
            }

            decreasingPrimeScoreStack.push(index);
        }

        long[] numOfSubarray = new long[nums.size()];
        for (int index = 0; index < nums.size(); index++) {
            numOfSubarray[index] = (long) (nextDominant[index] - index) * (index - prevDominant[index]);
        }

        List<int[]> sortedArray = new ArrayList<>();
        for (int index = 0; index < nums.size(); index++) {
            sortedArray.add(new int[]{nums.get(index), index});
        }
        sortedArray.sort((a, b) -> Integer.compare(b[0], a[0]));

        long score = 1;
        int processingIndex = 0;

        while (k > 0) {
            int[] element = sortedArray.get(processingIndex++);
            int num = element[0];
            int index = element[1];

            long operations = Math.min(k, numOfSubarray[index]);
            score = (score * power(num, operations)) % MOD;
            k -= (int) operations;
        }

        return (int) score;
    }

    private int[] calcPrimeScores(List<Integer> nums) {
        int[] primeScores = new int[nums.size()];
        int max = Collections.max(nums);
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int number = 2; number <= max; number++) {
            if (!isPrime[number])
                continue;

            primes.add(number);
            for (long multiple = (long) number * number; multiple <= max; multiple += number) {
                isPrime[(int) multiple] = false;
            }
        }

        for (int index = 0; index < nums.size(); index++) {
            int num = nums.get(index);
            for (int prime : primes) {
                if (num < prime * prime)
                    break;
                if (num % prime != 0)
                    continue;
                primeScores[index]++;
                while (num % prime == 0)
                    num /= prime;
            }
            if (num > 1)
                primeScores[index]++;
        }
        return primeScores;
    }

    private long power(long base, long exponent) {
        long res = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }

        return res;
    }

}
