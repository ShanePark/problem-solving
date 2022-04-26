package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1007MinimumDominoRotationsForEqualRow2 {

    @Test
    void test() {
        Assertions.assertThat(minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2})).isEqualTo(2);
        Assertions.assertThat(minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4})).isEqualTo(-1);
        Assertions.assertThat(minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2})).isEqualTo(1);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topCnt = new int[7];
        int[] bottomCnt = new int[7];
        int[] bothCnt = new int[7];
        for (int i = 0; i < tops.length; i++) {
            topCnt[tops[i]]++;
            bottomCnt[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                bothCnt[tops[i]]++;
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (topCnt[i] + bottomCnt[i] == tops.length + bothCnt[i]) {
                return Math.min(tops.length - topCnt[i], tops.length - bottomCnt[i]);
            }
        }

        return -1;
    }
}
