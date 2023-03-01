package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 길_찾기_게임 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]")))
                .isEqualTo(Ps.intArray("[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]"));
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        final int LENGTH = nodeinfo.length;
        for (int i = 0; i < LENGTH; i++) {
            nodes.add(new Node(i, nodeinfo[i][0], nodeinfo[i][1]));
        }
        nodes.sort((n1, n2) -> {
            if (n1.y == n2.y) {
                return Integer.compare(n1.x, n2.x);
            }
            return Integer.compare(n2.y, n1.y);
        });

        Node root = nodes.get(0);
        Queue<Node> parents = new LinkedList<>();
        parents.offer(root);

        for (int i = 1; i < LENGTH; i++) {
            Node first = nodes.get(i);
            Queue<Node> rows = new LinkedList<>();
            while (i < LENGTH && nodes.get(i).y == first.y) {
                Node node = nodes.get(i++);
                rows.offer(node);
                while (!parents.peek().canBeParent(node)) {
                    parents.poll();
                }
                Node parent = parents.peek();
                assert parent != null;
                parent.addChild(node);
            }
            parents = rows;
            i--;
        }

        int[][] answer = new int[2][LENGTH];
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        preOrder(preOrder, root);
        postOrder(postOrder, root);

        for (int i = 0; i < LENGTH; i++) {
            answer[0][i] = preOrder.get(i);
            answer[1][i] = postOrder.get(i);
        }
        return answer;
    }

    private void preOrder(List<Integer> preOrder, Node node) {
        if (node == null)
            return;
        preOrder.add(node.index);
        preOrder(preOrder, node.left);
        preOrder(preOrder, node.right);
    }


    private void postOrder(List<Integer> postOrder, Node node) {
        if (node == null)
            return;
        postOrder(postOrder, node.left);
        postOrder(postOrder, node.right);
        postOrder.add(node.index);
    }

    class Node {
        int index;
        int x;
        int y;
        int maxChildrenX = Integer.MAX_VALUE;
        int minChildrenX = -1;
        Position position;
        Node left;
        Node right;

        public Node(int i, int x, int y) {
            this.index = i + 1;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    ", left=" + (left == null ? null : left.index) +
                    ", right=" + (right == null ? null : right.index) +
                    ", maxChildrenX=" + maxChildrenX +
                    ", minChildrenX=" + minChildrenX +
                    "}";
        }

        public boolean canBeParent(Node node) {
            if (this.right != null)
                return false;
            return this.minChildrenX < node.x && node.x < this.maxChildrenX;
        }

        public void addChild(Node node) {
            node.maxChildrenX = this.maxChildrenX;
            node.minChildrenX = this.minChildrenX;
            if (this.x < node.x) {
                this.right = node;
                node.position = Position.RIGHT;
                node.minChildrenX = Math.max(this.x, this.minChildrenX);
            } else {
                this.left = node;
                node.position = Position.LEFT;
                node.maxChildrenX = Math.min(this.x, this.maxChildrenX);
            }
        }
    }

    enum Position {
        LEFT, RIGHT
    }

}
