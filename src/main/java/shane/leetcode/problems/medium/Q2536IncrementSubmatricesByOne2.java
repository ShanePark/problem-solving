package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 27ms
 * Beats42.54%
 */
public class Q2536IncrementSubmatricesByOne2 {

    @Test
    public void test() {
        assertThat(rangeAddQueries(3, Ps.intArray("[[1,1,2,2],[0,0,1,1]]"))).isEqualTo(Ps.intArray("[[1,1,0],[1,2,1],[0,1,1]]"));
        assertThat(rangeAddQueries(2, Ps.intArray("[[0,0,1,1]]"))).isEqualTo(Ps.intArray("[[1,1],[1,1]]"));
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr = new int[n + 1][n + 1];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[2]; i++) {
                arr[i][query[1]]++;
                arr[i][query[3] + 1]--;
            }
        }
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
                answer[i][j] = sum;
            }
        }
        return answer;
    }

}
