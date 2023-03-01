package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 105 ms Beats 84.78%
 * Memory 116.6 MB Beats 94.56%
 */
public class Q1519NumberOfNodesInTheSubTreeWithTheSameLabel3 {

    @Test
    public void test() {

        assertThat(countSubTrees(6, Ps.intArray("[[0,1],[0,2],[1,3],[3,4],[4,5]]"), "cbabaa")).containsExactly(1, 2, 1, 1, 2, 1);
        assertThat(countSubTrees(7, Ps.intArray("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"), "abaedcd")).containsExactly(2, 1, 1, 1, 1, 1, 1);
        assertThat(countSubTrees(4, Ps.intArray("[[0,1],[1,2],[0,3]]"), "bbbb")).containsExactly(4, 2, 1, 1);
    }

    @Test
    public void weirdCase() {
        assertThat(countSubTrees(4, Ps.intArray("[[0,2],[0,3],[1,2]]"), "aeed"))
                .containsExactly(1, 1, 2, 1);
    }

    //        @Test
    public void stackOverflow() {
        StringBuilder sb = new StringBuilder();
        final int LENGTH = 10_000;
        for (int i = 0; i < LENGTH; i++) {
            sb.append("a");
        }
        int[][] arr = new int[LENGTH][2];
        for (int i = 0; i < LENGTH; i++) {
            arr[i] = new int[]{i, i + 1};
        }
        countSubTrees(LENGTH, arr, sb.toString());
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int[] answer = new int[n];
        dfs(map, labels, answer, 0, -1);
        return answer;
    }

    private int[] dfs(Map<Integer, List<Integer>> map, String labels, int[] answer, int cur, int from) {
        int[] count = new int[26];

        for (Integer next : map.get(cur)) {
            if (next == from)
                continue;
            int[] sub = dfs(map, labels, answer, next, cur);
            for (int i = 0; i < 26; i++) {
                count[i] += sub[i];
            }
        }
        answer[cur] = ++count[labels.charAt(cur) - 'a'];
        return count;
    }

}
