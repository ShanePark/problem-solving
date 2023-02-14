package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 58 / 59 testcases passed
 */
public class Q1519NumberOfNodesInTheSubTreeWithTheSameLabel2 {

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

//    @Test
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
        Arrays.fill(answer, 1);
        ArrayList<Integer> parents = new ArrayList<>();
        parents.add(0);
        for (Integer next : map.get(0)) {
            dfs(map, labels, answer, next, parents, 0);
        }
        return answer;
    }

    private void dfs(Map<Integer, List<Integer>> map, String labels, int[] answer, int cur, List<Integer> parents, int from) {

        for (Integer parent : parents) {
            if (labels.charAt(parent) == labels.charAt(cur)) {
                answer[parent]++;
            }
        }
        parents.add(cur);
        for (Integer next : map.get(cur)) {
            if (next == from)
                continue;
            dfs(map, labels, answer, next, parents, cur);
        }
        parents.remove((Integer) cur);
    }

}
