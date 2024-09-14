package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2msBeats100.00%
 */
public class Q1310XORQueriesOfASubarray6 {

    @Test
    public void test() {
        assertThat(xorQueries(new int[]{4, 8, 2, 10}, Ps.intArray("[[2,3],[1,3],[0,0],[0,3]]"))).containsExactly(8, 0, 4, 4);
        assertThat(xorQueries(new int[]{1, 3, 4, 8}, Ps.intArray("[[0,1],[1,2],[0,3],[3,3]]"))).containsExactly(2, 7, 14, 8);
        assertThat(xorQueries(new int[]{15, 8, 8, 8, 15}, Ps.intArray("[[2,2],[3,3]]"))).containsExactly(8, 8);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] ^= dp[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 0) {
                answer[i] = dp[query[1]];
                continue;
            }
            if (query[0] == query[1]) {
                answer[i] = arr[query[0]];
                continue;
            }
            answer[i] = dp[query[0] - 1] ^ dp[query[1]];
        }

        return answer;
    }

}
