package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3495MinimumOperationsToMakeArrayElementsZero {

    @Test
    public void test() {
        assertThat(minOperations(Ps.intArray("[[1,2],[2,4]]"))).isEqualTo(3L);
        assertThat(minOperations(Ps.intArray("[[2,6]]"))).isEqualTo(4L);
    }

    public long minOperations(int[][] queries) {
        long answer = 0;

        for (int[] query : queries) {
            long operations = 0;
            for (int depth = 1, rangeStart = 1; depth < 17; depth++) {
                long rangeEnd = rangeStart * 4L;
                long overlapStart = Math.max((long) query[0], rangeStart);
                long overlapEnd = Math.min(query[1], rangeEnd - 1);

                if (overlapEnd >= overlapStart) {
                    long rangeSize = overlapEnd - overlapStart + 1;
                    operations += rangeSize * depth;
                }
                rangeStart = (int) rangeEnd;
            }

            answer += (operations + 1) / 2;
        }

        return answer;
    }

}
