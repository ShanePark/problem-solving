package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1038BinarySearchTreeToGreaterSumTree {

    @Test
    void test() {
        TreeNode root = TreeNode.ofWithNull(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        bstToGst(root).printTree();

    }

    public TreeNode bstToGst(TreeNode root) {
        Queue<Integer> q = new PriorityQueue();
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, q);
        int sum = 0;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sum -= poll;
            map.put(-poll, sum);
        }

        replaceDfs(root, map);

        return root;

    }

    private void replaceDfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return;
        root.val = map.get(root.val);
        replaceDfs(root.left, map);
        replaceDfs(root.right, map);
    }

    private void traverse(TreeNode root, Queue<Integer> q) {
        if (root == null)
            return;
        q.offer(-root.val);
        traverse(root.left, q);
        traverse(root.right, q);
    }


}
