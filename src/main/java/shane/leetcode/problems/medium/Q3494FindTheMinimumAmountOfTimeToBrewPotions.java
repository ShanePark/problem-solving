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
        long[] endTime = new long[skill.length];
        long[] prefixSum = new long[skill.length + 1];

        for (int i = 0; i < skill.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + skill[i];
        }

        endTime[0] = (long) skill[0] * mana[0];
        for (int i = 1; i < skill.length; i++) {
            endTime[i] = endTime[i - 1] + (long) skill[i] * mana[0];
        }

        for (int j = 1; j < mana.length; j++) {
            long[] newEndTime = new long[skill.length];

            long startTime = 0;
            for (int i = 0; i < skill.length; i++) {
                long arrival = startTime + prefixSum[i] * mana[j];
                if (arrival < endTime[i]) {
                    startTime = endTime[i] - prefixSum[i] * mana[j];
                }
            }

            newEndTime[0] = startTime + (long) skill[0] * mana[j];
            for (int i = 1; i < skill.length; i++) {
                newEndTime[i] = newEndTime[i - 1] + (long) skill[i] * mana[j];
            }

            endTime = newEndTime;
        }

        return endTime[skill.length - 1];
    }

}
