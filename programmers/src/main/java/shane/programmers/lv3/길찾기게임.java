package shane.programmers.lv3;

import com.tistory.shanepark.STool;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 길찾기게임 {

    @Test
    void test() {
        Assertions.assertThat(solution(STool.convertToIntArray("[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]"))).isDeepEqualTo(STool.convertToIntArray("[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]"));
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i + 1, nodeinfo[i]));
        }

        list.sort((o1, o2) -> {
            if (o1.point[1] != o2.point[1]) {
                return o2.point[1] - o1.point[1];
            } else {
                return o1.point[0] - o2.point[0];
            }
        });

        List<Node> heads = new ArrayList<>();
        List<Node> nextHeads = new ArrayList<>();
        Node root = list.get(0);
        nextHeads.add(root);

        int depth = root.point[1];
        loop:
        for (int i = 1; i < list.size(); i++) {
            Node node = list.get(i);

            if (depth != node.point[1]) {
                depth = node.point[1];
                heads = nextHeads;
                nextHeads = new ArrayList<>();
            }

            nextHeads.add(node);

            Node curhead = null;
            int diff = Integer.MAX_VALUE;
            for (Node head : heads) {
                int temp = Math.abs(head.point[0] - node.point[0]);
                if (diff > temp) {
                    diff = temp;
                    curhead = head;
                }
            }

            if (curhead.point[0] > node.point[0]) {
                curhead.left = node;
            } else if (curhead.point[0] < node.point[0]) {
                curhead.right = node;
            }

        }

        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();

        preOrder(root, preList);
        postOrder(root, postList);

        System.out.println("preList = " + preList);
        System.out.println("postList = " + postList);
        int[][] arr = new int[2][preList.size()];
        for (int i = 0; i < preList.size(); i++) {
            arr[0][i] = preList.get(i);
        }
        for (int i = 0; i < postList.size(); i++) {
            arr[1][i] = postList.get(i);
        }

        return arr;
    }

    private void preOrder(Node root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.index);

        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    private void postOrder(Node root, List<Integer> list) {
        if (root == null)
            return;

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.index);
    }


    class Node {
        int[] point;
        int index;
        Node left;
        Node right;

        public Node(int index, int[] point) {
            this.index = index;
            this.point = point;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    '}';
        }
    }
}
