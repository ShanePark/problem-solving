package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 19ms
 * Beats20.90%
 */
public class Q3025FindTheNumberOfWaysToPlacePeopleI {

    @Test
    public void test() {
        assertThat(numberOfPairs(Ps.intArray("[[3,1],[1,3],[1,1]]"))).isEqualTo(2);
        assertThat(numberOfPairs(Ps.intArray("[[6,2],[4,4],[2,6]]"))).isEqualTo(2);
        assertThat(numberOfPairs(Ps.intArray("[[1,1],[2,2],[3,3]]"))).isEqualTo(0);
    }

    public int numberOfPairs(int[][] points) {
        int answer = 0;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] > p2[0] || p1[1] < p2[1] || Arrays.equals(p1, p2))
                    continue;
                if (onlyTwoInside(points, p1, p2))
                    answer++;
            }
        }
        return answer;
    }

    private boolean onlyTwoInside(int[][] points, int[] p1, int[] p2) {
        int cnt = 0;
        for (int[] point : points) {
            if (p1[0] <= point[0] && point[0] <= p2[0] && p2[1] <= point[1] && point[1] <= p1[1]) {
                if (++cnt == 3)
                    return false;
            }
        }
        return true;
    }

}
