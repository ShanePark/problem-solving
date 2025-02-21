package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 21ms
 * Beats72.24%
 */
public class Q1261FindElementsInAContaminatedBinaryTree2 {
    @Test
    public void test() {
        TreeNode tree = TreeNode.of(-1, null, -1);
        FindElements findElements = new FindElements(tree);
        assertThat(findElements.find(1)).isEqualTo(false);
        assertThat(findElements.find(2)).isEqualTo(true);
    }

    @Test
    public void test2() {
        TreeNode tree = TreeNode.of(-1, -1, -1, -1, -1);
        FindElements findElements = new FindElements(tree);
        assertThat(findElements.find(1)).isEqualTo(true);
        assertThat(findElements.find(3)).isEqualTo(true);
        assertThat(findElements.find(5)).isEqualTo(false);
    }

    @Test
    public void test3() {
        TreeNode tree = TreeNode.of(-1, null, -1, -1, null, -1);
        FindElements findElements = new FindElements(tree);
        assertThat(findElements.find(2)).isEqualTo(true);
        assertThat(findElements.find(3)).isEqualTo(false);
        assertThat(findElements.find(4)).isEqualTo(false);
        assertThat(findElements.find(5)).isEqualTo(true);
    }

    private static class FindElements {

        private final Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            dfs(root, 0);
        }

        private void dfs(TreeNode node, int i) {
            if (node == null)
                return;
            set.add(i);
            dfs(node.left, 2 * i + 1);
            dfs(node.right, 2 * i + 2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }

}


