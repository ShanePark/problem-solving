package shane.leetcode.contest.weekly.w290;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * TLE
 */
public class Q3 {

    @Test
    public void test() {
        assertThat(countRectangles(STool.convertToIntArray("[[1,2],[2,3],[2,5]]"), STool.convertToIntArray("[[2,1],[1,4]]"))).containsExactly(2, 1);
        assertThat(countRectangles(STool.convertToIntArray("[[1,1],[2,2],[3,3]]"), STool.convertToIntArray("[[1,3],[1,1]]"))).containsExactly(1, 3);
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
