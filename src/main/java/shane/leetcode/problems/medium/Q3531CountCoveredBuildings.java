package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 40
 * ms
 * Beats
 * 72.63%
 */
public class Q3531CountCoveredBuildings {

    @Test
    public void test() {
        assertThat(countCoveredBuildings(3, Ps.intArray("[[1,2],[2,2],[3,2],[2,1],[2,3]]"))).isEqualTo(1);
        assertThat(countCoveredBuildings(3, Ps.intArray("[[1,1],[1,2],[2,1],[2,2]]"))).isEqualTo(0);
        assertThat(countCoveredBuildings(5, Ps.intArray("[[1,3],[3,2],[3,3],[3,5],[5,3]]"))).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(countCoveredBuildings(3, Ps.intArray("[[2,3],[1,2],[1,3],[2,2]]"))).isEqualTo(0);
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][] memoX = new int[n + 1][2];
        int[][] memoY = new int[n + 1][2];
        for (int[] building : buildings) {
            int y = building[0];
            int x = building[1];
            memoX[x][0] = memoX[x][0] == 0 ? y : Math.min(memoX[x][0], y);
            memoX[x][1] = memoX[x][1] == 0 ? y : Math.max(memoX[x][1], y);
            memoY[y][0] = memoY[y][0] == 0 ? x : Math.min(memoY[y][0], x);
            memoY[y][1] = memoY[y][1] == 0 ? x : Math.max(memoY[y][1], x);
        }
        int answer = 0;
        for (int[] building : buildings) {
            int y = building[0];
            int x = building[1];
            if (memoX[x][0] == y || memoX[x][1] == y || memoY[y][0] == x || memoY[y][1] == x)
                continue;
            answer++;
        }
        return answer;
    }

}
