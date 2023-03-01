package shane.leetcode.contest.weekly.w290;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class Q3_2 {

    @Test
    public void test() {
        assertThat(countRectangles(Ps.intArray("[[1,2],[2,3],[2,5]]"), Ps.intArray("[[2,1],[1,4]]"))).containsExactly(2, 1);
        assertThat(countRectangles(Ps.intArray("[[1,1],[2,2],[3,3]]"), Ps.intArray("[[1,3],[1,1]]"))).containsExactly(1, 3);
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[][] arrays = new int[rectangles.length + points.length][];

        for (int i = 0; i < rectangles.length; i++) {
            arrays[i] = rectangles[i];
        }

        for (int i = 0; i < points.length; i++) {
            arrays[rectangles.length + i] = new int[]{points[i][0], points[i][1], i};
        }

        Arrays.sort(arrays, (x, y) -> {
            if (x[0] != y[0])
                return -(x[0] - y[0]);
            return x.length - y.length;
        });

        int[] arrayY = new int[101];
        int[] ans = new int[points.length];
        for (int[] arr : arrays) {
            if (arr.length == 2) {
                for (int i = 0; i <= arr[1]; i++) {
                    arrayY[i]++;
                }
            } else {
                ans[arr[2]] = arrayY[arr[1]];
            }
        }
        return ans;
    }
}

