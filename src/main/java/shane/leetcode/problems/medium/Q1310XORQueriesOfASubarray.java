package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 698 ms
 */
public class Q1310XORQueriesOfASubarray {

    @Test
    public void test() {
        assertThat(xorQueries(new int[]{1, 3, 4, 8}, STool.convertToIntArray("[[0,1],[1,2],[0,3],[3,3]]"))).containsExactly(2, 7, 14, 8);
        assertThat(xorQueries(new int[]{4, 8, 2, 10}, STool.convertToIntArray("[[2,3],[1,3],[0,0],[0,3]]"))).containsExactly(8, 0, 4, 4);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int n = arr[start];

            start++;

            while (start <= end) {
                n ^= arr[start++];
            }
            answer[i] = n;
        }
        return answer;
    }
}
