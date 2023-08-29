package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 15ms Beats 42.09%of users with Java
 * Memory Details 44.30MB Beats 58.59%of users with Java
 */
public class Q2483MinimumPenaltyForAShop {

    @Test
    public void test() {
        assertThat(bestClosingTime("YYYY")).isEqualTo(4);
        assertThat(bestClosingTime("YYNY")).isEqualTo(2);
        assertThat(bestClosingTime("NNNNN")).isEqualTo(0);
    }

    public int bestClosingTime(String customers) {
        final int LENGTH = customers.length();
        int[] countOpen = new int[LENGTH + 1];
        for (int i = LENGTH - 1; i >= 0; i--) {
            boolean hasCustomer = customers.charAt(i) == 'Y';
            if (hasCustomer) {
                countOpen[i]++;
            }
            if (i < LENGTH - 1) {
                countOpen[i] += countOpen[i + 1];
            }
        }

        int curPenalty = 0;
        int minTime = customers.length() - 1;
        int minPenalty = LENGTH;
        for (int i = 0; i <= LENGTH; i++) {
            int penaltyIfCloseNow = countOpen[i];
            int penalty = curPenalty + penaltyIfCloseNow;
            if (penalty < minPenalty) {
                minTime = i;
                minPenalty = penalty;
            }
            if (i < LENGTH && customers.charAt(i) == 'N')
                curPenalty++;
        }
        return minTime;
    }

}
