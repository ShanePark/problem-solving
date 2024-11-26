package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1ms Beats100.00% 
 */
public class Q2924FindChampionII {

    @Test
    public void test() {
        assertThat(findChampion(4, Ps.intArray("[[0,2],[1,3],[1,2]]"))).isEqualTo(-1);
        assertThat(findChampion(3, Ps.intArray("[[0,1],[1,2]]"))).isEqualTo(0);
    }

    public int findChampion(int n, int[][] edges) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int[] edge : edges) {
            arr[edge[1]] = edge[0];
        }

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {
                if (answer != -1)
                    return -1;
                answer = i;
            }
        }
        return answer;
    }

}
