package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 99.45%
 * Memory 97.1 MB Beats 99.62%
 */
public class Q1971FindIfPathExistsInGraph {

    @Test
    public void test() {
        assertThat(validPath(10, Ps.intArray("[[0,7],[0,8],[6,1],[2,0],[0,4],[5,8],[4,7],[1,3],[3,5],[6,5]]"), 7, 5)).isTrue();
        assertThat(validPath(3, Ps.intArray("[[0,1],[1,2],[2,0]]"), 0, 2)).isTrue();
        assertThat(validPath(6, Ps.intArray("[[0,1],[0,2],[3,5],[5,4],[4,3]]"), 0, 5)).isFalse();
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int[] edge : edges) {
            addEdge(arr, edge);
        }
        return unionFind(arr, source) == unionFind(arr, destination);
    }

    private void addEdge(int[] arr, int[] edge) {
        int union1 = unionFind(arr, edge[0]);
        int union2 = unionFind(arr, edge[1]);
        arr[union2] = union1;
        arr[edge[1]] = union1; // optimization
    }

    private int unionFind(int[] arr, int n) {
        if (arr[n] == n)
            return n;
        return unionFind(arr, arr[n]);
    }

}
