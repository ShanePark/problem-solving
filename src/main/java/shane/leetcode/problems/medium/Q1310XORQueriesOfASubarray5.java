package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MLE
 */
public class Q1310XORQueriesOfASubarray5 {

    @Test
    public void test() {
        assertThat(xorQueries(new int[]{1, 3, 4, 8}, Ps.intArray("[[0,1],[1,2],[0,3],[3,3]]"))).containsExactly(2, 7, 14, 8);
        assertThat(xorQueries(new int[]{4, 8, 2, 10}, Ps.intArray("[[2,3],[1,3],[0,0],[0,3]]"))).containsExactly(8, 0, 4, 4);
        assertThat(xorQueries(new int[]{15, 8, 8, 8, 15}, Ps.intArray("[[2,2],[3,3]]"))).containsExactly(8, 8);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Integer[][] dp = new Integer[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = query(arr, queries[i][0], queries[i][1], dp);
        }
        return answer;
    }

    private int query(int[] arr, int from, int end, Integer[][] dp) {
        if (dp[from][end] != null)
            return dp[from][end];
        return dp[from][end] = arr[from] ^ query(arr, from + 1, end, dp);
    }

}
