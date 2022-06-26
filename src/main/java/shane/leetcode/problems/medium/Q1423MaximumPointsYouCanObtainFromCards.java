package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1423MaximumPointsYouCanObtainFromCards {

    @Test
    public void test() {
        assertThat(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3)).isEqualTo(12);
        assertThat(maxScore(new int[]{2, 2, 2}, 2)).isEqualTo(4);
    }

    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;

        int[] fromStart = new int[length];
        int[] fromEnd = new int[length];

        fromStart[0] = cardPoints[0];
        fromEnd[0] = cardPoints[length - 1];
        for (int i = 1; i < length; i++) {
            fromStart[i] = fromStart[i - 1] + cardPoints[i];
            fromEnd[i] = fromEnd[i - 1] + cardPoints[length - 1 - i];
        }

        int max = 0;
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            int start = i == 0 ? 0 : fromStart[i - 1];
            int end = j == 0 ? 0 : fromEnd[j - 1];
            max = Math.max(max, start + end);
        }

        return max;
    }
}
