package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 Runtime: 1 ms, faster than 100.00% of Java online submissions for XOR Queries of a Subarray.
 Memory Usage: 54.4 MB, less than 87.50% of Java online submissions for XOR Queries of a Subarray.
 */
@SuppressWarnings("ALL")
public class Q1310XORQueriesOfASubarray4 {

    @Test
    public void test() {
        assertThat(xorQueries(new int[]{15, 8, 8, 8, 15}, Ps.intArray("[[2,2],[3,3]]"))).containsExactly(8, 8);
        assertThat(xorQueries(new int[]{16}, Ps.intArray("[[0,0],[0,0],[0,0]]"))).containsExactly(16, 16, 16);
        assertThat(xorQueries(new int[]{1, 3, 4, 8}, Ps.intArray("[[0,1],[1,2],[0,3],[3,3]]"))).containsExactly(2, 7, 14, 8);
        assertThat(xorQueries(new int[]{4, 8, 2, 10}, Ps.intArray("[[2,3],[1,3],[0,0],[0,3]]"))).containsExactly(8, 0, 4, 4);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (start == 0) {
                answer[i] = prefix[end];
            } else {
                answer[i] = prefix[start - 1] ^ prefix[end];
            }
        }
        return answer;
    }
}
