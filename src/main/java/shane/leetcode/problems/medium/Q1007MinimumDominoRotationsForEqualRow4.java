package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5
 * ms
 * Beats
 * 54.93%
 */
public class Q1007MinimumDominoRotationsForEqualRow4 {

    @Test
    void test() {
        assertThat(minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2})).isEqualTo(2);
        assertThat(minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4})).isEqualTo(-1);
    }

    @Test
    public void test2() {
        assertThat(minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2})).isEqualTo(1);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topCnt = new int[7];
        int[] bottomCnt = new int[7];
        int[] sameCnt = new int[7];
        for (int i = 0; i < tops.length; i++) {
            topCnt[tops[i]]++;
            bottomCnt[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                sameCnt[tops[i]]++;
            }
        }

        int min = tops.length;
        for (int i = 1; i <= 6; i++) {
            if (topCnt[i] + bottomCnt[i] - sameCnt[i] < tops.length)
                continue;
            min = Math.min(min, Math.min(topCnt[i], tops.length - topCnt[i]));
            min = Math.min(min, Math.min(bottomCnt[i], tops.length - bottomCnt[i]));
        }
        if (min == tops.length)
            return -1;
        return min;
    }

}
