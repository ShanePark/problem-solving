package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR {

    @Test
    public void test() {
        assertThat(countTriplets(new int[]{2, 3, 1, 6, 7})).isEqualTo(4);
        assertThat(countTriplets(new int[]{1, 1, 1, 1, 1})).isEqualTo(10);
    }

    int[][] memo = new int[300][300];

    public int countTriplets(int[] arr) {
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (xor(arr, i, j - 1) == xor(arr, j, k)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private int xor(int[] arr, int from, int to) {
        if (from == to) {
            return arr[from];
        }
        if (memo[from][to] >= 0) {
            return memo[from][to];
        }

        memo[from][to] = (xor(arr, from, to - 1) ^ arr[to]);
        return memo[from][to];
    }
}
