package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 75.4%
 * Memory 56 MB Beats 86.55%
 */
public class Q1319NumberOfOperationsToMakeNetworkConnected2 {

    @Test
    public void test() {
        assertThat(makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}})).isEqualTo(0);
        assertThat(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}})).isEqualTo(-1);
        assertThat(makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}})).isEqualTo(1);
        assertThat(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}})).isEqualTo(2);
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        UnionFinder uf = new UnionFinder(n);
        for (int[] connection : connections) {
            uf.union(connection);
        }
        return uf.size - 1;
    }

    private class UnionFinder {

        private final int[] arr;
        int size;

        UnionFinder(int n) {
            this.arr = new int[n];
            IntStream.range(0, n).forEach(i -> arr[i] = i);
            this.size = n;
        }

        public void union(int[] connection) {
            int union1 = find(connection[0]);
            int union2 = find(connection[1]);
            if (union1 == union2) {
                return;
            }
            size--;
            arr[union2] = union1;
        }

        private int find(int i) {
            if (arr[i] == i)
                return i;
            int union = find(arr[i]);
            arr[i] = union;
            return union;
        }
    }

}
