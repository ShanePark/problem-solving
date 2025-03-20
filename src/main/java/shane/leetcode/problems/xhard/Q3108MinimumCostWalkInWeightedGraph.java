package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
26ms
Beats30.59%
 */
public class Q3108MinimumCostWalkInWeightedGraph {

    @Test
    public void test() {
        assertThat(minimumCost(5, Ps.intArray("[[0,1,7],[1,3,7],[1,2,1]]"), Ps.intArray("[[0,3],[3,4]]"))).containsExactly(1, -1);
        assertThat(minimumCost(3, Ps.intArray("[[0,2,7],[0,1,15],[1,2,6],[1,2,1]]"), Ps.intArray("[[1,2]]"))).containsExactly(0);
    }

    @Test
    public void fail() {
        assertThat(minimumCost(4, Ps.intArray("[[2,3,1],[1,3,5],[1,2,6],[3,0,7],[1,3,7],[0,2,5],[0,1,7]]"),
                Ps.intArray("[[2,1],[1,2],[0,1],[2,0],[0,2],[1,2],[3,2],[0,3],[2,1],[1,2]]"))).containsExactly(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int[] q = query[i];
            answer[i] = uf.weightAnd(q[0], q[1]);
        }
        return answer;
    }

    static class UnionFind {
        private final int[] union;
        private final Map<Integer, Integer> unionAnd = new HashMap<>();

        UnionFind(int size) {
            union = new int[size];
            for (int i = 0; i < size; i++) {
                union[i] = i;
            }
        }

        public void union(int i, int j, int weight) {
            int ufi = unionFind(i);
            int ufj = unionFind(j);
            int ufMin = Math.min(ufi, ufj);
            union[ufi] = ufMin;
            union[ufj] = ufMin;
            unionAnd.merge(ufMin, weight, and());
            if (unionAnd.containsKey(ufi)) {
                unionAnd.merge(ufMin, unionAnd.get(ufi), and());
            }
            if (unionAnd.containsKey(ufj)) {
                unionAnd.merge(ufMin, unionAnd.get(ufj), and());
            }
        }

        private static BiFunction<Integer, Integer, Integer> and() {
            return (a, b) -> a & b;
        }

        public int weightAnd(int i, int j) {
            int union = unionFind(i);
            if (union != unionFind(j))
                return -1;
            return unionAnd.get(union);
        }

        private int unionFind(int i) {
            if (union[i] == i) {
                return i;
            }
            return union[i] = unionFind(union[i]);
        }
    }

}
