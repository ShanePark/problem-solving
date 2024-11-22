package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1072FlipColumnsForMaximumNumberofEqualRows {

    @Test
    public void test() {
        assertThat(maxEqualRowsAfterFlips(Ps.intArray("[[0,1],[1,1]]"))).isEqualTo(1);
        assertThat(maxEqualRowsAfterFlips(Ps.intArray("[[0,1],[1,0]]"))).isEqualTo(2);
        assertThat(maxEqualRowsAfterFlips(Ps.intArray("[[0,0,0],[0,0,1],[1,1,0]]"))).isEqualTo(2);
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            String str = Arrays.stream(row)
                    .map(i -> row[0] == 1 ? i : Math.abs(1 - i))
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            map.merge(str, 1, Integer::sum);
        }
        return map.values().stream().max(Integer::compareTo).get();
    }

}
