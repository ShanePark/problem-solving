package shane.leetcode.problems.easy;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1725NumberOfRectanglesThatCanFormTheLargestSquare {

    @Test
    public void test() {
        assertThat(countGoodRectangles(Ps.intArray("[[5,8],[3,9],[5,12],[16,5]]"))).isEqualTo(3);
        assertThat(countGoodRectangles(Ps.intArray("[[2,3],[3,7],[4,3],[3,7]]"))).isEqualTo(3);
        assertThat(countGoodRectangles(Ps.intArray("[[5,8],[3,9],[3,12]]"))).isEqualTo(1);
    }

    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int cnt = 0;
        for (int[] rectangle : rectangles) {
            int length = Math.min(rectangle[0], rectangle[1]);
            if (length > max) {
                cnt = 1;
                max = length;
            } else if (length == max) {
                cnt++;
            }
        }
        return cnt;
    }
}
