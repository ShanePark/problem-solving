package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MLE
 * Memory Limit Exceeded
 */
public class Q1310XORQueriesOfASubarray2 {

    @Test
    public void test() {
        assertThat(xorQueries(new int[]{1, 3, 4, 8}, Ps.intArray("[[0,1],[1,2],[0,3],[3,3]]"))).containsExactly(2, 7, 14, 8);
        assertThat(xorQueries(new int[]{4, 8, 2, 10}, Ps.intArray("[[2,3],[1,3],[0,0],[0,3]]"))).containsExactly(8, 0, 4, 4);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] memo = new int[arr.length + 1][arr.length + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int n = arr[start];

            int cur = start + 1;

            while (cur <= end) {
                if (memo[cur][end] > 0) {
                    n ^= memo[cur][end];
                    break;
                }
                n ^= arr[cur];
                memo[start][cur] = n;
                cur++;
            }
            answer[i] = n;
        }
        return answer;
    }
}
