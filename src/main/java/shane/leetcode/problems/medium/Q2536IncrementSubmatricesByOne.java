package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 659ms
 * Beats5.26%
 */
public class Q2536IncrementSubmatricesByOne {

    @Test
    public void test() {
        assertThat(rangeAddQueries(3, Ps.intArray("[[1,1,2,2],[0,0,1,1]]"))).isEqualTo(Ps.intArray("[[1,1,0],[1,2,1],[0,1,1]]"));
        assertThat(rangeAddQueries(2, Ps.intArray("[[0,0,1,1]]"))).isEqualTo(Ps.intArray("[[1,1],[1,1]]"));
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] answer = new int[n][n];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[2]; i++) {
                for (int j = query[1]; j <= query[3]; j++) {
                    answer[i][j]++;
                }
            }
        }
        return answer;
    }

}
