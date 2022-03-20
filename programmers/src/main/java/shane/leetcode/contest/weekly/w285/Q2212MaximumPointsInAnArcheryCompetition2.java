package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2212MaximumPointsInAnArcheryCompetition2 {

    @Test
    void test() {
        Assertions.assertThat(maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0})).containsExactly(0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 3, 1);
        Assertions.assertThat(maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2})).containsExactly(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0);
        Assertions.assertThat(maximumBobPoints(89, new int[]{3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5})).containsExactly(21, 3, 0, 2, 8, 2, 17, 8, 4, 14, 4, 6);
    }

    int[] maxSheet;
    int maxPoint;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        maxPoint = 0;
        bt(aliceArrows, new int[12], numArrows, 0, 0);
        return maxSheet;
    }

    private void bt(int[] aliceArrows, int[] bobArrows, int remainArrows, int i, int currentPoint) {
        if (i == 12 || remainArrows == 0) {
            if (currentPoint > maxPoint) {
                maxPoint = currentPoint;
                maxSheet = bobArrows.clone();
                maxSheet[0] += remainArrows;
            }
            return;
        }
        // getCurrentIndexScore
        int necessary = aliceArrows[i] + 1;
        if (remainArrows >= necessary) {
            bobArrows[i] = necessary;
            bt(aliceArrows, bobArrows, remainArrows - necessary, i + 1, currentPoint + i);
            bobArrows[i] = 0;
        }

        // skip
        bt(aliceArrows, bobArrows, remainArrows, i + 1, currentPoint);

    }

}
