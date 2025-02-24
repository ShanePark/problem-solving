package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 145ms
 * Beats
 */
public class Q2467MostProfitablePathInATree {

    @Test
    public void test() {
        assertThat(mostProfitablePath(Ps.intArray("[[0,1],[1,2],[1,3],[3,4]]"), 3, new int[]{-2, 4, 2, -4, 6})).isEqualTo(6);
        assertThat(mostProfitablePath(Ps.intArray("[[0,1]]"), 1, new int[]{-7280, 2350})).isEqualTo(-7280);
    }

    @Test
    public void test2() {
        assertThat(mostProfitablePath(Ps.intArray("[[0,2],[0,5],[1,3],[1,5],[2,4]]"), 4, new int[]{5018, 8388, 6224, 3466, 3808, 3456})).isEqualTo(20328);
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        final int LENGTH = amount.length;
        Tree[] trees = new Tree[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            trees[i] = new Tree(i, amount[i]);
        }
        for (int[] edge : edges) {
            Tree node1 = trees[edge[0]];
            Tree node2 = trees[edge[1]];
            node1.adjacent.add(node2);
            node2.adjacent.add(node1);
        }
        Tree treeAlice = trees[0];
        Tree treeBob = trees[bob];

        calcDistanceFromBob(treeBob, treeAlice, 0, new boolean[LENGTH]);
        return (int) max(treeAlice, new boolean[LENGTH], 0);
    }

    private long max(Tree node, boolean[] visited, int distance) {
        long val = node.value;
        if (node.distanceFromBob == distance) {
            val /= 2;
        }
        if (node.distanceFromBob < distance) {
            val = 0;
        }
        if (0 < distance && node.isLeaf())
            return val;

        long max = Integer.MIN_VALUE;
        visited[node.index] = true;
        for (Tree next : node.adjacent) {
            if (visited[next.index])
                continue;
            max = Math.max(max, max(next, visited, distance + 1));
        }
        return val + max;
    }

    private boolean calcDistanceFromBob(Tree cur, Tree target, int distance, boolean[] visited) {
        visited[cur.index] = true;
        if (cur == target)
            return true;
        boolean isAlicePath = false;
        for (Tree tree : cur.adjacent) {
            if (visited[tree.index])
                continue;
            isAlicePath |= calcDistanceFromBob(tree, target, distance + 1, visited);
        }
        if (!isAlicePath)
            return false;
        cur.distanceFromBob = distance;
        return true;
    }

    static class Tree {
        final int index;
        long value;
        Set<Tree> adjacent = new HashSet<>();
        int distanceFromBob = Integer.MAX_VALUE;

        Tree(int index, int value) {
            this.index = index;
            this.value = value;
        }

        boolean isLeaf() {
            return this.adjacent.size() == 1;
        }
    }

}
