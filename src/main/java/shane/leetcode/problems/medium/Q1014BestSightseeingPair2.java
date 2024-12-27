package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3ms Beats97.03%
 */
public class Q1014BestSightseeingPair2 {

    @Test
    public void test() {
        assertThat(maxScoreSightseeingPair(new int[]{2, 8, 1, 5, 2, 6})).isEqualTo(11);
        assertThat(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6})).isEqualTo(11);
        assertThat(maxScoreSightseeingPair(new int[]{1, 2})).isEqualTo(2);
    }

    public int maxScoreSightseeingPair(int[] values) {
        int maxBefore = values[0];
        int maxBeforeDistance = 1;
        int answer = 0;
        for (int i = 1; i < values.length; i++) {
            int val = values[i];
            answer = Math.max(answer, val + maxBefore - maxBeforeDistance);
            if (maxBefore - maxBeforeDistance < val) {
                maxBefore = val;
                maxBeforeDistance = 0;
            }
            maxBeforeDistance++;
        }
        return answer;
    }

}
