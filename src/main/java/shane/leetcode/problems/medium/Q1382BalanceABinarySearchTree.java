package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1382BalanceABinarySearchTree {

    @Test
    public void test() {
        TreeNode root = TreeNode.ofWithNull(new Integer[]{1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4});
        TreeNode output = balanceBST(root);
        output.printTree();
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsAdd(root, list);
        Collections.sort(list);
        return listToTreeNode(list);
    }

    private TreeNode listToTreeNode(List<Integer> list) {
        if (list.isEmpty())
            return null;
        if (list.size() == 1)
            return new TreeNode(list.get(0));
        if (list.size() == 2) {
            TreeNode result = new TreeNode(list.get(0));
            result.right = new TreeNode(list.get(1));
        }

        int midIndex = list.size() / 2;
        TreeNode result = new TreeNode(list.get(midIndex));
        List<Integer> sub1 = list.subList(0, midIndex);
        List<Integer> sub2 = list.subList(midIndex + 1, list.size());
        result.left = listToTreeNode(sub1);
        result.right = listToTreeNode(sub2);
        return result;
    }

    private void dfsAdd(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        dfsAdd(node.left, list);
        dfsAdd(node.right, list);
    }
}
