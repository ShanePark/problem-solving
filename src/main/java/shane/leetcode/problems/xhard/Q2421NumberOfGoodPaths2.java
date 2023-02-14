package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * unionFind optimization
 * Runtime 112 ms Beats 81.75%
 * Memory 68.3 MB Beats 61.50%
 */
public class Q2421NumberOfGoodPaths2 {

    @Test
    public void test() {
        assertThat(numberOfGoodPaths(new int[]{1, 3, 2, 1, 3}, Ps.intArray("[[0,1],[0,2],[2,3],[2,4]]"))).isEqualTo(6);
        assertThat(numberOfGoodPaths(new int[]{1, 1, 2, 2, 3}, Ps.intArray("[[0,1],[1,2],[2,3],[2,4]]"))).isEqualTo(7);
        assertThat(numberOfGoodPaths(new int[]{1}, Ps.intArray("[]"))).isEqualTo(1);
    }


    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> valueIndexes = new HashMap<>();
        final int LENGTH = vals.length;
        for (int i = 0; i < LENGTH; i++) {
            int value = vals[i];
            List<Integer> indexes = valueIndexes.get(value);
            if (indexes == null) {
                indexes = new ArrayList<>();
                valueIndexes.put(value, indexes);
            }
            indexes.add(i);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < LENGTH; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int i1 = edge[0];
            int i2 = edge[1];
            if (vals[i1] < vals[i2]) {
                graph.get(i2).add(i1);
            } else {
                graph.get(i1).add(i2);
            }
        }

        int[] union = new int[LENGTH];
        int answer = 0;
        for (int i = 0; i < LENGTH; i++) {
            union[i] = i;
        }

        List<Integer> sortedKeys = valueIndexes.keySet().stream().sorted().collect(Collectors.toList());

        for (int value : sortedKeys) {
            for (int u : valueIndexes.get(value)) {
                for (int v : graph.get(u)) {
                    union(union, u, v);
                }
            }

            HashMap<Integer, Integer> group = new HashMap<>();

            for (int u : valueIndexes.get(value)) {
                group.put(unionFind(union, u), group.getOrDefault(unionFind(union, u), 0) + 1);
            }

            answer += valueIndexes.get(value).size();

            for (int key : group.keySet()) {
                int size = group.get(key);
                answer += size * (size - 1) / 2;
            }
        }

        return answer;
    }

    void union(int[] union, int i, int j) {
        int iUnion = unionFind(union, i);
        int jUnion = unionFind(union, j);
        if (iUnion == jUnion) {
            return;
        }
        if (union[iUnion] <= union[jUnion]) {
            union[j] = i;
        } else {
            union[i] = j;
        }
    }

    private int unionFind(int[] union, int i) {
        if (i == union[i])
            return i;
        union[i] = unionFind(union, union[i]);
        return union[i];
    }

}
