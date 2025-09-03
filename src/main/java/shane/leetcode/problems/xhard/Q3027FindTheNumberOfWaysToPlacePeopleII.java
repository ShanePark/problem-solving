package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3027FindTheNumberOfWaysToPlacePeopleII {

    @Test
    public void test() {
        assertThat(numberOfPairs(Ps.intArray("[[1,1],[2,2],[3,3]]"))).isEqualTo(0);
        assertThat(numberOfPairs(Ps.intArray("[[6,2],[4,4],[2,6]]"))).isEqualTo(2);
        assertThat(numberOfPairs(Ps.intArray("[[3,1],[1,3],[1,1]]"))).isEqualTo(2);
    }

    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int answer = 0;
        for (int i = 0; i < points.length; i++) {
            loop:
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] < points[j][1])
                    continue;
                for (int k = i + 1; k < j; k++) {
                    if (points[k][1] >= points[j][1] && points[k][1] <= points[i][1])
                        continue loop;
                }
                answer++;
            }
        }
        return answer;
    }

}
