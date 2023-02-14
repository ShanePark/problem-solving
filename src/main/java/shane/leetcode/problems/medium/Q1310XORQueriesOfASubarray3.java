package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1310XORQueriesOfASubarray3 {

    @Test
    public void test() {
        assertThat(xorQueries(new int[]{1, 3, 4, 8}, Ps.intArray("[[0,1],[1,2],[0,3],[3,3]]"))).containsExactly(2, 7, 14, 8);
        assertThat(xorQueries(new int[]{4, 8, 2, 10}, Ps.intArray("[[2,3],[1,3],[0,0],[0,3]]"))).containsExactly(8, 0, 4, 4);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int n = arr[start];

            int cur = start + 1;

            while (cur <= end) {
                Integer memo = map.get(cur + " " + end);
                if (memo != null) {
                    n ^= memo;
                    break;
                }
                n ^= arr[cur];
                map.put(start + " " + cur, n);
                cur++;
            }
            answer[i] = n;
        }
        return answer;
    }
}
