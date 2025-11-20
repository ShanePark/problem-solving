package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q757SetIntersectionSizeAtLeastTwo {

    @Test
    public void test() {
        assertThat(intersectionSizeTwo(Ps.intArray("[[1,3],[3,7],[8,9]]"))).isEqualTo(5);
        assertThat(intersectionSizeTwo(Ps.intArray("[[1,3],[1,4],[2,5],[3,5]]"))).isEqualTo(3);
        assertThat(intersectionSizeTwo(Ps.intArray("[[1,2],[2,3],[2,4],[4,5]]"))).isEqualTo(5);
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int p1 = -1, p2 = -1;
        int answer = 0;

        for (int[] interval : intervals) {
            if (p2 >= interval[0]) {
                if ((p1 >= interval[0])) {
                    continue;
                }
                answer++;
                p1 = p2;
                p2 = interval[1];
                continue;
            }
            answer += 2;
            p1 = interval[1] - 1;
            p2 = interval[1];
        }
        return answer;
    }

}

