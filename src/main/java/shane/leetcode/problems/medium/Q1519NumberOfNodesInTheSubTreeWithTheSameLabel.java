package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 57 / 59 testcases passed
 */
public class Q1519NumberOfNodesInTheSubTreeWithTheSameLabel {

    @Test
    public void test() {

        assertThat(countSubTrees(6, STool.convertToIntArray("[[0,1],[0,2],[1,3],[3,4],[4,5]]"), "cbabaa")).containsExactly(1, 2, 1, 1, 2, 1);
        assertThat(countSubTrees(7, STool.convertToIntArray("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"), "abaedcd")).containsExactly(2, 1, 1, 1, 1, 1, 1);
        assertThat(countSubTrees(4, STool.convertToIntArray("[[0,1],[1,2],[0,3]]"), "bbbb")).containsExactly(4, 2, 1, 1);
    }

    /**
     * this is weird case
     */
    @Test
    public void test2() {
        assertThat(countSubTrees(4, STool.convertToIntArray("[[0,2],[0,3],[1,2]]"), "aeed"))
                .containsExactly(1, 1, 2, 1);
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int[] edge : edges) {
            if (set.add(edge[1])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                map.get(edge[1]).add(edge[0]);
                set.add(edge[0]);
            }
        }

        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        for (Integer next : map.get(0)) {
            dfs(map, labels, answer, 0, next, true);
        }
        return answer;
    }

    private void dfs(Map<Integer, List<Integer>> map, String labels, int[] answer, int target, int cur, boolean spread) {
        if (labels.charAt(target) == labels.charAt(cur)) {
            answer[target]++;
        }
        for (Integer next : map.get(cur)) {
            dfs(map, labels, answer, target, next, false);
            if (spread)
                dfs(map, labels, answer, cur, next, true);
        }
    }

}
