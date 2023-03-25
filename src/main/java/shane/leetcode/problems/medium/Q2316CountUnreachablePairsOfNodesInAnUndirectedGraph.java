package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2316CountUnreachablePairsOfNodesInAnUndirectedGraph {

    @Test
    void test() {
        assertThat(countPairs(7, Ps.intArray("[[0,2],[0,5],[2,4],[1,6],[5,4]]"))).isEqualTo(14);
        assertThat(countPairs(3, Ps.intArray("[[0,1],[0,2],[1,2]]"))).isEqualTo(0);
    }

    public long countPairs(int n, int[][] edges) {
        UnionFinder uf = new UnionFinder(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        List<Integer> unionSizes = uf.getUnionSizes();
        long sum = 0;
        for (int i = 0; i < unionSizes.size(); i++) {
            for (int j = i + 1; j < unionSizes.size(); j++) {
                if (i == j)
                    continue;
                sum += (long) unionSizes.get(i) * unionSizes.get(j);
            }
        }
        return sum;
    }

    class UnionFinder {
        final int[] union;

        public UnionFinder(int size) {
            this.union = new int[size];
            IntStream.range(0, size).forEach(i -> union[i] = i);
        }

        public void union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            union[jRoot] = iRoot;
        }

        private int find(int i) {
            if (union[i] == i)
                return i;
            int root = find(union[i]);
            union[i] = root;
            return root;
        }

        public List<Integer> getUnionSizes() {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int i = 0; i < union.length; i++) {
                int root = find(i);
                cntMap.merge(root, 1, Integer::sum);
            }
            return cntMap.keySet().stream()
                    .map(root -> cntMap.get(root))
                    .collect(Collectors.toList());
        }

    }

}
