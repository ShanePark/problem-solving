package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 158 / 175 testcases passed
 */
public class Q652FindDuplicateSubtrees {

    @Test
    public void test() {
        assertThat(findDuplicateSubtrees(TreeNode.of(1, 2, 3, 4, null, 2, 4, null, null, 4)))
                .containsExactlyInAnyOrder(TreeNode.of(2, 4), TreeNode.of(4));
        assertThat(findDuplicateSubtrees(TreeNode.of(2, 1, 1)))
                .containsExactlyInAnyOrder(TreeNode.of(1));
        assertThat(findDuplicateSubtrees(TreeNode.of(2, 2, 2, 3, null, 3, null)))
                .containsExactlyInAnyOrder(TreeNode.of(2, 3), TreeNode.of(3));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, Integer> hashCount = new HashMap<>();
        Map<Integer, TreeNode> hashMap = new HashMap<>();
        dfs(root, hashCount, hashMap);
        return hashCount.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> hashMap.get(e.getKey()))
                .collect(Collectors.toList());
    }

    private void dfs(TreeNode node, Map<Integer, Integer> hashCount, Map<Integer, TreeNode> hashMap) {
        if (node == null)
            return;
        int hash = hashTree(node);
        hashCount.merge(hash, 1, Integer::sum);
        hashMap.put(hash, node);
        dfs(node.left, hashCount, hashMap);
        dfs(node.right, hashCount, hashMap);
    }

    private int hashTree(TreeNode node) {
        if (node == null) return 0;
        return node.val + hash(node.left, node.right);
    }

    private int hash(TreeNode... trees) {
        int result = 1;

        for (TreeNode tree : trees)
            result = 31 * result + (tree == null ? 0 : hashTree(tree));

        return result;
    }

}
