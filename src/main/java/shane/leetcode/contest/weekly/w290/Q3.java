package shane.leetcode.contest.weekly.w290;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * TLE
 */
public class Q3 {

    @Test
    public void test() {
        assertThat(countRectangles(Ps.intArray("[[1,2],[2,3],[2,5]]"), Ps.intArray("[[2,1],[1,4]]"))).containsExactly(2, 1);
        assertThat(countRectangles(Ps.intArray("[[1,1],[2,2],[3,3]]"), Ps.intArray("[[1,3],[1,1]]"))).containsExactly(1, 3);
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] answer = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int cnt = 0;
            for (int[] rectangle : rectangles) {
                if (point[0] <= rectangle[0] && point[1] <= rectangle[1]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

}
