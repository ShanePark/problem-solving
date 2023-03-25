package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;
import shane.leetcode.util.Leet;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 59 ms Beats 57.9%
 * Memory 93.7 MB Beats 93.10%
 */
public class Q2316CountUnreachablePairsOfNodesInAnUndirectedGraph3 {

    @Test
    void test() {
        assertThat(countPairs(6, Ps.intArray("[[0,1],[2,3],[4,5]]"))).isEqualTo(12);
        assertThat(countPairs(7, Ps.intArray("[[0,2],[0,5],[2,4],[1,6],[5,4]]"))).isEqualTo(14);
        assertThat(countPairs(3, Ps.intArray("[[0,1],[0,2],[1,2]]"))).isEqualTo(0);
    }

    @Test
    void test2() {
        String filename = "Q2316CountUnreachablePairsOfNodesInAnUndirectedGraph.txt";
        String text = Leet.readFileText(this.getClass(), filename);
        int[][] edges = Ps.intArray(text);
        assertThat(countPairs(100000, edges)).isEqualTo(4999756275L);
    }

    public long countPairs(int n, int[][] edges) {
        UnionFinder uf = new UnionFinder(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        Map<Integer, Integer> unionSizes = uf.getUnionSizes();
        long sum = 0;
        for (Integer key : unionSizes.keySet()) {
            Integer size = unionSizes.get(key);
            for (Map.Entry<Integer, Integer> e : unionSizes.entrySet()) {
                if (key == e.getKey()) {
                    sum += (long) key * size * key * (e.getValue() - 1) / 2;
                } else {
                    Integer sizeOfUnion = e.getKey();
                    Integer sameSizeUnions = e.getValue();
                    sum += (long) key * size * sizeOfUnion * sameSizeUnions;
                }
            }
            unionSizes.put(key, 0);
        }
        return sum;
    }

    class UnionFinder {
        final int[] union;
        final Map<Integer, Integer> cntMap;

        public UnionFinder(int size) {
            this.union = new int[size];
            cntMap = new HashMap<>();
            IntStream.range(0, size).forEach(i -> {
                union[i] = i;
                cntMap.put(i, 1);
            });
        }

        public void union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot)
                return;
            union[jRoot] = iRoot;
            cntMap.put(iRoot, cntMap.get(iRoot) + cntMap.get(jRoot));
            cntMap.remove(jRoot);
        }

        private int find(int i) {
            if (union[i] == i)
                return i;
            int root = find(union[i]);
            union[i] = root;
            return root;
        }

        public Map<Integer, Integer> getUnionSizes() {
            Map<Integer, Integer> map = new HashMap<>();
            cntMap.keySet().stream()
                    .map(root -> cntMap.get(root))
                    .forEach(cnt -> map.merge(cnt, 1, Integer::sum));
            return map;
        }

    }

}
