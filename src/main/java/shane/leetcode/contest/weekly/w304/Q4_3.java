package shane.leetcode.contest.weekly.w304;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q4_3 {

    @Test
    public void test() {
        assertThat(longestCycle(new int[]{3, 4, 0, 2, -1, 2})).isEqualTo(3);
        assertThat(longestCycle(new int[]{1, 2, 0, 4, 5, 6, 3, 8, 9, 7})).isEqualTo(4);
        assertThat(longestCycle(new int[]{3, 3, 4, 2, 3})).isEqualTo(3);
        assertThat(longestCycle(new int[]{2, -1, 3, 1})).isEqualTo(-1);
    }

    public int longestCycle(int[] edges) {
        int res = -1;
        int[][] memo = new int[edges.length][2];
        Arrays.fill(memo, new int[]{-1, -1});

        for (int i = 0; i < edges.length; i++) {
            for (int j = i, dist = 0; j != -1; j = edges[j]) {
                int dist_i = memo[j][0];
                int from_i = memo[j][1];
                if (dist_i == -1) {
                    memo[j] = new int[]{dist++, i};
                } else {
                    if (from_i == i) {
                        res = Math.max(res, dist - dist_i);
                    }
                    break;
                }
            }
        }
        return res;
    }

}
