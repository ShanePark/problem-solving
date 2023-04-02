package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 66 ms Beats 86.36%
 * Memory 61.4 MB Beats 78.10%
 */
public class Q2300SuccessfulPairsOfSpellsAndPotions {

    @Test
    void test() {
        assertThat(successfulPairs(new int[]{1}, new int[]{15, 5, 6, 7}, 15)).containsExactly(1);
        assertThat(successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)).containsExactly(2, 0, 2);
        assertThat(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)).containsExactly(4, 0, 3);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        double[] arr = new double[potions.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (double) success / potions[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < spells.length; i++) {
            spells[i] = binarySearch(arr, spells[i]) + 1;
        }
        return spells;
    }

    private int binarySearch(double[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        if (num < arr[0])
            return -1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (num < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
