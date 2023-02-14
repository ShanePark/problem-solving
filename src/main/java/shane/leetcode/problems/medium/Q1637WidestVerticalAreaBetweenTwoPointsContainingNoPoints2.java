package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q1637WidestVerticalAreaBetweenTwoPointsContainingNoPoints2 {

    @Test
    void test() {
        Assertions.assertThat(maxWidthOfVerticalArea(Ps.intArray("[[8,7],[9,9],[7,4],[9,7]]"))).isEqualTo(1);
        Assertions.assertThat(maxWidthOfVerticalArea(Ps.intArray("[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]"))).isEqualTo(3);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            max = Math.max(max, arr[i + 1] - arr[i]);
        }
        return max;
    }

}
