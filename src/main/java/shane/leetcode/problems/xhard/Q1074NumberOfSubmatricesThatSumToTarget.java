package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my Solution
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/803353/Java-Solution-with-Detailed-Explanation
 */
public class Q1074NumberOfSubmatricesThatSumToTarget {

    @Test
    public void test() {
        assertThat(numSubmatrixSumTarget(Ps.intArray("[[0,1,0],[1,1,1],[0,1,0]]"), 0)).isEqualTo(4);
        assertThat(numSubmatrixSumTarget(Ps.intArray("[[1,-1],[-1,1]]"), 0)).isEqualTo(5);
        assertThat(numSubmatrixSumTarget(Ps.intArray("[[0,1,1,1,0,1],[0,0,0,0,0,1],[0,0,1,0,0,1],[1,1,0,1,1,0],[1,0,0,1,0,0]]"), 0)).isEqualTo(43);
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length + 1;
        int cnt = 0;
        int[][] dp = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = dp[i][j - 1] + matrix[i][j - 1];
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = i + 1; j < width; j++) {
                int sum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int k = 0; k < height; k++) {
                    sum += dp[k][j] - dp[k][i];
                    cnt += map.getOrDefault(sum - target, 0);
                    map.merge(sum, 1, Integer::sum);
                }
            }
        }
        return cnt;
    }
}
