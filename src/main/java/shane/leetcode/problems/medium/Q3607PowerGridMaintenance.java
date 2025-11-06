package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 187ms
 * Beats20.08%
 */
public class Q3607PowerGridMaintenance {

    @Test
    public void test() {
        assertThat(processQueries(5, Ps.intArray("[[1,2],[2,3],[3,4],[4,5]]"), Ps.intArray("[[1,3],[2,1],[1,1],[2,2],[1,2]]"))).containsExactly(3, 2, 3);
        assertThat(processQueries(3, Ps.intArray("[]"), Ps.intArray("[[1,1],[2,1],[1,1]]"))).containsExactly(1, -1);
    }

    @Test
    public void test2() {
        int[][] q = Ps.intArray("[[2,4],[1,5],[1,3],[1,2],[2,1],[2,2],[1,5],[1,2],[2,2],[1,5],[2,3],[1,4],[1,5],[1,1],[2,1],[2,5],[2,1],[2,1],[2,5],[2,1],[1,4],[2,4],[1,2],[1,2],[2,1],[1,5],[2,3],[2,5],[2,5],[2,2],[1,1],[2,3],[2,5],[1,3],[2,2],[2,3],[2,5],[2,3],[2,2],[2,3],[1,1],[2,5],[2,4],[1,4],[2,3],[2,4],[2,5],[1,5],[2,2],[2,1],[2,2],[2,5],[2,2],[1,1],[2,4],[1,3],[1,2],[2,2],[1,1],[2,2],[1,4],[2,2],[1,3],[2,2],[2,2],[1,4],[1,1],[1,1],[1,2],[1,5],[1,5]]");
        assertThat(processQueries(5, Ps.intArray("[[2,3],[2,4],[4,1],[5,1]]"), q)).containsExactly(5, 3, 2, 5, 3, 5, 5, 5, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        UnionFind uf = new UnionFind(c);
        for (int[] conn : connections) {
            uf.union(conn[0] - 1, conn[1] - 1);
        }

        Map<Integer, Group> groups = new HashMap<>();
        for (int i = 0; i < c; i++) {
            groups.computeIfAbsent(uf.find(i), g -> new Group()).register(i + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int[] query : queries) {
            int i = query[1];
            Group group = groups.get(uf.find(i - 1));
            if (query[0] == 1) {
                answer.add(group.check(i));
                continue;
            }
            group.offline(i);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    class UnionFind {
        final int[] union;

        UnionFind(int n) {
            this.union = new int[n];
            for (int i = 0; i < n; i++)
                union[i] = i;
        }

        int find(int x) {
            if (union[x] != x)
                union[x] = find(union[x]);
            return union[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) union[pb] = pa;
        }
    }

    class Group {
        final TreeSet<Integer> tree = new TreeSet<>();

        public Integer check(int q) {
            if (tree.contains(q))
                return q;
            if (tree.isEmpty())
                return -1;
            return tree.first();
        }

        public void offline(int i) {
            tree.remove(i);
        }

        public void register(Integer key) {
            this.tree.add(key);
        }
    }


}
