package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Runtime 1 ms Beats 98.97%
 * Memory 44.2 MB Beats 18.4%
 */
public class Q547NumberOfProvinces {

    @Test
    void test() {
        Assertions.assertThat(findCircleNum(Ps.intArray("[[1,1,0],[1,1,0],[0,0,1]]"))).isEqualTo(2);
        Assertions.assertThat(findCircleNum(Ps.intArray("[[1,0,0],[0,1,0],[0,0,1]]"))).isEqualTo(3);
    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        UnionFind uf = new UnionFind(length);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 0)
                    continue;
                uf.union(i, j);
            }
        }
        Set<Integer> provinces = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int province = uf.unionFind(i);
            provinces.add(province);
        }
        return provinces.size();
    }

    class UnionFind {
        int[] arr;

        public UnionFind(int length) {
            this.arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = i;
            }
        }

        public void union(int i, int j) {
            int iRoot = unionFind(i);
            int jRoot = unionFind(j);
            arr[jRoot] = iRoot;
        }

        private int unionFind(int i) {
            if (arr[i] == i)
                return i;
            int root = unionFind(arr[i]);
            arr[i] = root;
            return root;
        }
    }

}
