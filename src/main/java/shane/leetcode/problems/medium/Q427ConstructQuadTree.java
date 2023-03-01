package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 71.9%
 * Memory 42.6 MB Beats 45.57%
 */
public class Q427ConstructQuadTree {

    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length, 0, grid[0].length);
    }

    private Node construct(int[][] grid, int iFrom, int iTo, int jFrom, int jTo) {
        if (iTo - iFrom == 1)
            return new Node(grid[iFrom][jFrom] == 1, true);
        Node topLeft = construct(grid, iFrom, (iFrom + iTo) / 2, jFrom, (jFrom + jTo) / 2);
        Node topRight = construct(grid, iFrom, (iFrom + iTo) / 2, (jFrom + jTo) / 2, jTo);
        Node bottomLeft = construct(grid, (iFrom + iTo) / 2, iTo, jFrom, (jFrom + jTo) / 2);
        Node bottomRight = construct(grid, (iFrom + iTo) / 2, iTo, (jFrom + jTo) / 2, jTo);
        int trueCnt = countTrue(topLeft, topRight, bottomLeft, bottomRight);
        int leafCnt = countLeaf(topLeft, topRight, bottomLeft, bottomRight);
        if (leafCnt == 4 && trueCnt == 0) {
            return new Node(false, true);
        }
        if (leafCnt == 4 && trueCnt == 4) {
            return new Node(true, true);
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private int countLeaf(Node... nodes) {
        int cnt = 0;
        for (Node node : nodes) {
            if (node.isLeaf)
                cnt++;
        }
        return cnt;
    }

    private int countTrue(Node... nodes) {
        int cnt = 0;
        for (Node node : nodes) {
            if (node.val)
                cnt++;
        }
        return cnt;
    }

    @Test
    void test() {
        Node node = construct(Ps.intArray("[[0,1],[1,0]]"));
        assertThat(node.isLeaf).isFalse();
        assertThat(node.val).isTrue();
        assertThat(node.topLeft.isLeaf).isTrue();
        assertThat(node.topLeft.val).isEqualTo(false);
        assertThat(node.topRight.isLeaf).isTrue();
        assertThat(node.topRight.val).isEqualTo(true);
        assertThat(node.bottomLeft.isLeaf).isTrue();
        assertThat(node.bottomLeft.val).isEqualTo(true);
        assertThat(node.bottomRight.isLeaf).isTrue();
    }

    @Test
    void test2() {
        Node node = construct(Ps.intArray("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]"));
        assertThat(node.isLeaf).isFalse();
        assertThat(node.val).isTrue();
        assertThat(node.topLeft.isLeaf).isTrue();
        assertThat(node.topRight.isLeaf).isFalse();
        assertThat(node.topRight.val).isTrue();
        assertThat(node.topRight.topRight.isLeaf).isTrue();
        assertThat(node.topRight.topRight.val).isFalse();
    }

    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

}
