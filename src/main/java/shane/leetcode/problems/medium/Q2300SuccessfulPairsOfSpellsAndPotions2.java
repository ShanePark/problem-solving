package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 46
 * ms
 * Beats
 * 69.51%
 */
public class Q2300SuccessfulPairsOfSpellsAndPotions2 {

    @Test
    void test() {
        assertThat(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)).containsExactly(4, 0, 3);
        assertThat(successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)).containsExactly(2, 0, 2);
    }

    @Test
    public void tle() {
        int[] spells = new int[100_000];
        int[] potions = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            spells[i] = i;
            potions[i] = i;
        }
        assertThat(successfulPairs(spells, potions, 1)).hasSize(100_000);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long min = (long) Math.ceil((double) success / spell);
            int binarySearch = binarySearch(potions, min);
            spells[i] = potions.length - binarySearch;
        }
        return spells;
    }

    private int binarySearch(int[] potions, long n) {
        int left = 0;
        int right = potions.length - 1;
        if (potions[right] < n)
            return right + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < n) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        return left;
    }

}
