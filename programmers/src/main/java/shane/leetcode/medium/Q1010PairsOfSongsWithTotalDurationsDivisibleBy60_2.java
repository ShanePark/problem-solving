package shane.leetcode.medium;

import org.junit.jupiter.api.Assertions;

public class Q1010PairsOfSongsWithTotalDurationsDivisibleBy60_2 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        Assertions.assertEquals(3, numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        for (int i = 0; i < time.length; i++) {
            arr[time[i] % 60]++;
        }
        int sum = 0;
        for (int i = 0; i < arr[0]; i++) {
            sum += i;
        }
        for (int i = 0; i < arr[30]; i++) {
            sum += i;
        }
        for (int i = 1; i < 30; i++) {
            sum += arr[i] * arr[60 - i];
        }
        return sum;
    }
}
