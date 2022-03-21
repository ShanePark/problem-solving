package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2212MaximumPointsInAnArcheryCompetition3 {

    @Test
    void test() {
        Assertions.assertThat(maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0})).containsExactly(0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 3, 1);
        Assertions.assertThat(maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2})).containsExactly(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0);
        Assertions.assertThat(maximumBobPoints(89, new int[]{3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5})).containsExactly(21, 3, 0, 2, 8, 2, 17, 8, 4, 14, 4, 6);
    }

    int bobPoint;
    int[] maxBob;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        bobPoint = 0;
        calculate(aliceArrows, new int[12], 0, numArrows, 0);
        return maxBob;
    }

    private void calculate(int[] alice, int[] bob, int index, int remainArr, int point) {
        if (index == 12 || remainArr == 0) {
            if (point > bobPoint) {
                bobPoint = point;
                maxBob = bob.clone();
                maxBob[0] += remainArr;
            }
            return;
        }

        // part 1
        int necessary = alice[index] + 1;
        if (remainArr >= necessary) {
            bob[index] = necessary;
            calculate(alice, bob, index + 1, remainArr - necessary, point + index);
            bob[index] = 0;
        }

        // part 2
        calculate(alice, bob, index + 1, remainArr, point);

    }

}
