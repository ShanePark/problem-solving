package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q834SumOfDistancesInTree4 {

    @Test
    public void test() {
        assertThat(sumOfDistancesInTree(6, Ps.intArray("[[0,1],[0,2],[2,3],[2,4],[2,5]]")))
                .isEqualTo(new int[]{8, 12, 6, 10, 10, 10});
        assertThat(sumOfDistancesInTree(1, Ps.intArray("[]")))
                .isEqualTo(new int[]{0});
        assertThat(sumOfDistancesInTree(2, Ps.intArray("[[1,0]]")))
                .isEqualTo(new int[]{1, 1});
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Set<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int[] subtreeSize = new int[n];
        int[] answer = new int[n];

        dfs(0, -1, tree, subtreeSize, answer);
        adjustDistances(0, -1, tree, n, subtreeSize, answer);

        return answer;
    }

    private void dfs(int node, int parent, List<Set<Integer>> tree, int[] subtreeSize, int[] distanceSum) {
        subtreeSize[node] = 1;
        for (int next : tree.get(node)) {
            if (next == parent)
                continue;
            dfs(next, node, tree, subtreeSize, distanceSum);
            subtreeSize[node] += subtreeSize[next];
            distanceSum[node] += (distanceSum[next] + subtreeSize[next]);
        }
    }

    private void adjustDistances(int node, int parent, List<Set<Integer>> tree, int n, int[] subtreeSize, int[] distanceSum) {
        if (parent >= 0) {
            distanceSum[node] = distanceSum[parent] - subtreeSize[node] + (n - subtreeSize[node]);
        }
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent)
                continue;
            adjustDistances(neighbor, node, tree, n, subtreeSize, distanceSum);
        }
    }

}
