package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 62.40%
 * Memory 56.2 MB Beats 85.58%
 */
public class Q1319NumberOfOperationsToMakeNetworkConnected {

    @Test
    public void test() {
        assertThat(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}})).isEqualTo(-1);
        assertThat(makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}})).isEqualTo(1);
        assertThat(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}})).isEqualTo(2);
    }

    public int makeConnected(int n, int[][] connections) {
        UnionFinder uf = new UnionFinder(n);
        for (int[] connection : connections) {
            uf.union(connection);
        }
        return uf.getMoves();
    }

    private class UnionFinder {

        private final int[] arr;

        UnionFinder(int n) {
            this.arr = new int[n];
            IntStream.range(0, n).forEach(i -> arr[i] = i);
        }

        int extraCables = 0;

        public void union(int[] connection) {
            int union1 = find(connection[0]);
            int union2 = find(connection[1]);
            if (union1 == union2) {
                extraCables++;
                return;
            }
            int union = Math.min(union1, union2);
            arr[union1] = union;
            arr[union2] = union;
        }

        private int find(int i) {
            if (arr[i] == i)
                return i;
            int union = find(arr[i]);
            arr[i] = union;
            return union;
        }

        public int getMoves() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                set.add(find(i));
            }
            int moves = set.size() - 1;
            if (extraCables < moves)
                return -1;
            return moves;
        }
    }

}
