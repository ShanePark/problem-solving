package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 37ms
 * Beats96.51%
 */
public class Q3160FindTheNumberOfDistinctColorsAmongTheBalls2 {

    @Test
    public void test() {
        assertThat(queryResults(4, Ps.intArray("[[1,4],[2,5],[1,3],[3,4]]"))).containsExactly(1, 2, 2, 3);
        assertThat(queryResults(4, Ps.intArray("[[0,1],[1,2],[2,2],[3,4],[4,5]]"))).containsExactly(1, 2, 2, 3, 4);
    }

    @Test
    public void mle() {
        assertThat(queryResults((int) 1e9, Ps.intArray("[[0,1],[1,2],[2,2],[3,4],[4,5]]"))).containsExactly(1, 2, 2, 3, 4);
    }

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> colors = new HashMap<>();
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            Integer colorBefore = colors.get(q[0]);
            colors.put(q[0], q[1]);
            if (colorBefore != null) {
                int cnt = cntMap.merge(colorBefore, -1, Integer::sum);
                if (cnt == 0)
                    cntMap.remove(colorBefore);
            }
            cntMap.merge(q[1], 1, Integer::sum);
            answer[i] = cntMap.size();
        }
        return answer;
    }

}
