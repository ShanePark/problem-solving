package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1007MinimumDominoRotationsForEqualRow {

    @Test
    void test() {
        Assertions.assertThat(minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2})).isEqualTo(2);
        Assertions.assertThat(minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4})).isEqualTo(-1);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] cnt = new int[6];
        for (int top : tops) {
            cnt[top - 1]++;
        }
        for (int bottom : bottoms) {
            cnt[bottom - 1]++;
        }

        int n = -1;
        for (int i = 0; i < 6; i++) {
            if (cnt[i] >= tops.length) {
                n = i;
            }
        }
        if (n < 0) {
            return n;
        }

        n++;

        int topCnt = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == n && bottoms[i] != n) {
                topCnt++;
            } else if (bottoms[i] == n && tops[i] != n) {
                topCnt--;
            } else if (tops[i] != n && bottoms[i] != n) {
                return -1;
            }
        }

        int count = 0;
        int[] main = topCnt > 0 ? tops : bottoms;
        for (int i = 0; i < tops.length; i++) {
            if (main[i] != n) {
                count++;
            }
        }

        return count;
    }
}
