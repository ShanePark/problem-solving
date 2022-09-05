package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 5 ms, faster than 43.54% of Java online submissions for N-ary Tree Level Order Traversal.
 * Memory Usage: 47.3 MB, less than 54.06% of Java online submissions for N-ary Tree Level Order Traversal.
 */
public class Q429NaryTreeLevelOrderTraversal {

    @Test
    public void test() {
        List<Node> children3 = new ArrayList<>();
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        children3.add(node5);
        children3.add(node6);
        Node node3 = new Node(3, children3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> children1 = new ArrayList<>();
        children1.add(node3);
        children1.add(node2);
        children1.add(node4);
        Node node1 = new Node(1, children1);
        assertThat(levelOrder(node1)).isEqualTo(STool.convertToIntList("[[1],[3,2,4],[5,6]]"));

        assertThat(levelOrder(null)).isEqualTo(STool.convertToIntList("[]"));
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return Collections.EMPTY_LIST;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        List<List<Integer>> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                list.add(poll.val);
                if (poll.children != null && !poll.children.isEmpty()) {
                    q.addAll(poll.children);
                }
            }
            answer.add(list);
        }

        return answer;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
