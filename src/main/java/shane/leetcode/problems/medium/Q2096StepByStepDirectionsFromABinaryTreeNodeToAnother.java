package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime160msBeats15.24%
 */
public class Q2096StepByStepDirectionsFromABinaryTreeNodeToAnother {

    @Test
    public void test() {
        assertThat(getDirections(TreeNode.of(5, 1, 2, 3, null, 6, 4), 3, 6)).isEqualTo("UURL");
        assertThat(getDirections(TreeNode.of(2, 1), 2, 1)).isEqualTo("L");
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Set<Integer> destParents = new HashSet<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = makeParentMap(root, nodeMap);

        findDestParent(root, destValue, destParents);
        destParents.add(destValue);

        StringBuilder sb = new StringBuilder();
        TreeNode start = nodeMap.get(startValue);
        findDest(start, destValue, sb, destParents, parentMap);
        return sb.toString();
    }

    private void findDest(TreeNode cur, int destination, StringBuilder sb, Set<Integer> destParents, Map<TreeNode, TreeNode> parentMap) {
        if (cur == null || cur.val == destination)
            return;
        if (!destParents.contains(cur.val)) {
            sb.append("U");
            findDest(parentMap.get(cur), destination, sb, destParents, parentMap);
            return;
        }

        if (cur.right != null && destParents.contains(cur.right.val)) {
            sb.append("R");
            findDest(cur.right, destination, sb, destParents, parentMap);
            return;
        }
        sb.append("L");
        findDest(cur.left, destination, sb, destParents, parentMap);
    }

    private Map<TreeNode, TreeNode> makeParentMap(TreeNode root, Map<Integer, TreeNode> nodeMap) {
        nodeMap.put(root.val, root);
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        traverse(root, root.left, parentMap, nodeMap);
        traverse(root, root.right, parentMap, nodeMap);
        return parentMap;
    }

    private void traverse(TreeNode parent, TreeNode cur, Map<TreeNode, TreeNode> map, Map<Integer, TreeNode> nodeMap) {
        if (cur == null)
            return;
        nodeMap.put(cur.val, cur);
        map.put(cur, parent);
        traverse(cur, cur.left, map, nodeMap);
        traverse(cur, cur.right, map, nodeMap);
    }

    private boolean findDestParent(TreeNode node, int destValue, Set<Integer> destParents) {
        if (node == null)
            return false;
        if (node.val == destValue) {
            return true;
        }
        boolean left = findDestParent(node.left, destValue, destParents);
        boolean right = findDestParent(node.right, destValue, destParents);
        if (left || right) {
            destParents.add(node.val);
            return true;
        }
        return false;
    }

}
