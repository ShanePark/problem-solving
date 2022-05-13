package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q117PopulatingNextRightPointersInEachNodeII {

    @Test
    public void test() {
        assertThat(connect(null)).isNull();
    }

    public Node connect(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        dfs(root, map, 0);

        for (List<Node> list : map.values()) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }

        return root;
    }

    private void dfs(Node node, Map<Integer, List<Node>> map, int level) {
        if (node == null)
            return;
        map.putIfAbsent(level, new ArrayList<>());
        List<Node> nodes = map.get(level);
        nodes.add(node);
        dfs(node.left, map, level + 1);
        dfs(node.right, map, level + 1);
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
