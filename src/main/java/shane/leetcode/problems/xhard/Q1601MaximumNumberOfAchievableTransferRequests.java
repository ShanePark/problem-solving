package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 18 ms Beats 66.67%
 * Memory 40.5 MB Beats 54.55%
 */
public class Q1601MaximumNumberOfAchievableTransferRequests {

    @Test
    void test() {
        assertThat(maximumRequests(3, Ps.intArray("[[0,0],[1,2],[2,1]]"))).isEqualTo(3);
        assertThat(maximumRequests(5, Ps.intArray("[[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]"))).isEqualTo(5);
        assertThat(maximumRequests(4, Ps.intArray("[[0,3],[3,1],[1,2],[2,0]]"))).isEqualTo(4);
    }

    public int maximumRequests(int n, int[][] requests) {
        int[] arr = new int[n];
        return dfs(0, arr, requests, 0);
    }

    public int dfs(int index, int[] arr, int[][] requests, int include) {
        if (index == requests.length) {
            for (int i : arr) {
                if (i != 0)
                    return 0;
            }
            return include;
        }
        int[] request = requests[index];

        int pass = dfs(index + 1, arr, requests, include);
        int from = request[0];
        int to = request[1];
        arr[from]--;
        arr[to]++;
        int included = dfs(index + 1, arr, requests, include + 1);
        arr[from]++;
        arr[to]--;
        return Math.max(pass, included);
    }

}
