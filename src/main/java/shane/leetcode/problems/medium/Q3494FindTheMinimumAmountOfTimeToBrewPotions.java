package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3494FindTheMinimumAmountOfTimeToBrewPotions {

    @Test
    public void test() {
        assertThat(minTime(new int[]{1, 5, 2, 4}, new int[]{5, 1, 4, 2})).isEqualTo(110L);
        assertThat(minTime(new int[]{1, 1, 1}, new int[]{1, 1, 1})).isEqualTo(5L);
        assertThat(minTime(new int[]{1, 2, 3, 4}, new int[]{1, 2})).isEqualTo(21L);
    }

    public long minTime(int[] skill, int[] mana) {
        final int LENGTH = skill.length;
        long[] holdingTimes = new long[LENGTH];
        for (int k : mana) {
            long endTime = 0;
            for (int i = 0; i < LENGTH; i++) {
                endTime = Math.max(endTime, holdingTimes[i]);
                endTime += (long) skill[i] * k;
            }
            holdingTimes[LENGTH - 1] = endTime;
            for (int i = LENGTH - 2; i >= 0; i--) {
                holdingTimes[i] = holdingTimes[i + 1] - (long) skill[i + 1] * k;
            }
        }
        return holdingTimes[LENGTH - 1];
    }

}
