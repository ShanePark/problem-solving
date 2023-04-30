package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 53 ms Beats 12.75%
 * Memory 117 MB Beats 10.74%
 */
public class Q1579RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    @Test
    void test() {
        assertThat(maxNumEdgesToRemove(2, Ps.intArray("[[1,1,2],[2,1,2],[3,1,2]]"))).isEqualTo(2);
        assertThat(maxNumEdgesToRemove(4, Ps.intArray("[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]"))).isEqualTo(2);
        assertThat(maxNumEdgesToRemove(4, Ps.intArray("[[3,1,2],[3,2,3],[1,1,4],[2,1,4]]"))).isEqualTo(0);
        assertThat(maxNumEdgesToRemove(4, Ps.intArray("[[3,2,3],[1,1,2],[2,3,4]]"))).isEqualTo(-1);
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(arr -> -arr[0]));
        int[] aliceUf = new int[n];
        int[] bobUf = new int[n];
        for (int i = 0; i < n; i++) {
            aliceUf[i] = i;
            bobUf[i] = i;
        }
        int newConnectionsCount = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int node1 = edge[1] - 1;
            int node2 = edge[2] - 1;
            boolean newConnection = false;
            if (type == 1 || type == 3) {
                newConnection |= unionAndReturnIsNewConnection(aliceUf, node1, node2);
            }
            if (type == 2 || type == 3) {
                newConnection |= unionAndReturnIsNewConnection(bobUf, node1, node2);
            }
            if (newConnection)
                newConnectionsCount++;
        }
        if (isOneUnion(aliceUf) && isOneUnion(bobUf)) {
            return edges.length - newConnectionsCount;
        }
        return -1;
    }

    private boolean isOneUnion(int[] union) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < union.length; i++) {
            set.add(unionFind(union, i));
        }
        return set.size() == 1;
    }

    private Integer unionFind(int[] union, int i) {
        if (union[i] == i)
            return i;
        Integer root = unionFind(union, union[i]);
        union[i] = root;
        return root;
    }

    private boolean unionAndReturnIsNewConnection(int[] union, int node1, int node2) {
        int root1 = unionFind(union, node1);
        int root2 = unionFind(union, node2);
        boolean isNewConnection = root1 != root2;
        if (isNewConnection) {
            union[root2] = root1;
        }
        return isNewConnection;
    }

}
