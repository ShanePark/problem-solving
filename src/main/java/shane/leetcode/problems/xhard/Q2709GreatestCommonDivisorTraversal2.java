package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Optimized by GPT
 */
public class Q2709GreatestCommonDivisorTraversal2 {

    @Test
    public void test() {
        assertThat(canTraverseAllPairs(new int[]{20, 6})).isTrue();
        assertThat(canTraverseAllPairs(new int[]{2, 3, 6})).isTrue();
        assertThat(canTraverseAllPairs(new int[]{3, 9, 5})).isFalse();
        assertThat(canTraverseAllPairs(new int[]{4, 3, 12, 8})).isTrue();
    }

    @Test
    public void tle() {
        int size = (int) 1e5;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        assertThat(canTraverseAllPairs(arr)).isFalse();
    }

    public boolean canTraverseAllPairs(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, List<Integer>> factors = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int factor = 2; factor * factor <= nums[i]; factor++) {
                if (nums[i] % factor == 0) {
                    factors.computeIfAbsent(factor, n -> new ArrayList<>()).add(i);
                    while (nums[i] % factor == 0) {
                        nums[i] /= factor;
                    }
                }
            }
            if (nums[i] > 1) {
                factors.computeIfAbsent(nums[i], n -> new ArrayList<>()).add(i);
            }
        }

        factors.values().forEach(l -> {
            for (Integer i : l) {
                uf.union(l.get(0), i);
            }
        });
        return uf.isOneGroup();
    }

    static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }

        public boolean isOneGroup() {
            int group = find(0);
            for (int i : parent) {
                if (find(i) != group)
                    return false;
            }
            return true;
        }
    }

}
