package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2641CousinsInBinaryTreeII {

    @Test
    public void test() {
        TreeNode original = TreeNode.of(5, 4, 9, 1, 10, null, 7);
        TreeNode answer = replaceValueInTree(original);
        answer.printTree();
        assertThat(answer).isEqualTo(TreeNode.of(0, 0, 0, 7, 7, null, 11));

        assertThat(replaceValueInTree(TreeNode.of(3, 1, 2))).isEqualTo(TreeNode.of(0, 0, 0));
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> depthSum = new HashMap<>();
        Map<TreeNode, Integer> saveValues = new HashMap<>();

        calcDepthSum(root, 0, depthSum);
        saveModify(root, null, 0, depthSum, saveValues);
        adjustModify(root, saveValues);

        return root;
    }

    private void adjustModify(TreeNode node, Map<TreeNode, Integer> saveValues) {
        if (node == null)
            return;
        node.val = saveValues.get(node);
        adjustModify(node.left, saveValues);
        adjustModify(node.right, saveValues);
    }

    private void saveModify(TreeNode node, TreeNode parent, int depth, Map<Integer, Integer> depthSum, Map<TreeNode, Integer> saveValues) {
        if (node == null)
            return;
        int cousinsSum = depthSum.getOrDefault(depth, 0);
        if (parent != null) {
            if (parent.left != null) {
                cousinsSum -= parent.left.val;
            }
            if (parent.right != null) {
                cousinsSum -= parent.right.val;
            }
        } else {
            cousinsSum -= node.val;
        }
        saveModify(node.left, node, depth + 1, depthSum, saveValues);
        saveModify(node.right, node, depth + 1, depthSum, saveValues);
        saveValues.put(node, cousinsSum);
    }

    private void calcDepthSum(TreeNode node, int depth, Map<Integer, Integer> depthSum) {
        if (node == null)
            return;
        depthSum.merge(depth, node.val, Integer::sum);
        calcDepthSum(node.left, depth + 1, depthSum);
        calcDepthSum(node.right, depth + 1, depthSum);
    }


}
