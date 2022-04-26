package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Assertions;

/**
 * Time Limit Exceeded
 */
public class Q1010PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        Assertions.assertEquals(3, numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
