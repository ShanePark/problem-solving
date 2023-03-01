package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 42 ms Beats 80.59%
 * Memory 85.7 MB Beats 61.18%
 */
public class Q1443MinimumTimeToCollectAllApplesInATree {

    @Test
    public void test() {
        assertThat(minTime(4, Ps.intArray("[[0,2],[0,3],[1,2]]"), List.of(false, true, false, false))).isEqualTo(4);
        assertThat(minTime(7, Ps.intArray("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"), List.of(false, false, true, false, true, true, false)))
                .isEqualTo(8);
        assertThat(minTime(7, Ps.intArray("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"), List.of(false, false, true, false, false, true, false)))
                .isEqualTo(6);
        assertThat(minTime(7, Ps.intArray("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"), List.of(false, false, false, false, false, false, false)))
                .isEqualTo(0);
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        List<Integer> firstChildren = map.get(0);
        int sum = 0;
        for (Integer child : firstChildren) {
            sum += travel(child, map, hasApple, 0);
        }
        return sum;
    }

    private int travel(int i, Map<Integer, List<Integer>> map, List<Boolean> hasApple, int from) {
        int distance = 0;
        for (Integer next : map.get(i)) {
            if (next == from)
                continue;
            distance += travel(next, map, hasApple, i);
        }

        if (hasApple.get(i) || distance > 0) {
            distance += 2;
        }
        return distance;
    }

}
