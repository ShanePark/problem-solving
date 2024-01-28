package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 120 ms Beats 72.83% of users with Java
 */
public class Q1074NumberOfSubmatricesThatSumToTarget2 {

    @Test
    public void test() {
        assertThat(numSubmatrixSumTarget(Ps.intArray("[[1,-1],[-1,1]]"), 0)).isEqualTo(5);
        assertThat(numSubmatrixSumTarget(Ps.intArray("[[0,1,0],[1,1,1],[0,1,0]]"), 0)).isEqualTo(4);
        assertThat(numSubmatrixSumTarget(Ps.intArray("[[904]]"), 0)).isEqualTo(0);
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;
        int answer = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int[] dp = new int[WIDTH];
                for (int i_ = i; i_ < HEIGHT; i_++) {
                    int curRowSum = 0;
                    for (int j_ = j; j_ < WIDTH; j_++) {
                        curRowSum += matrix[i_][j_];
                        dp[j_] = dp[j_] + curRowSum;
                        if (dp[j_] == target)
                            answer++;
                    }
                }
            }
        }
        return answer;
    }

}
