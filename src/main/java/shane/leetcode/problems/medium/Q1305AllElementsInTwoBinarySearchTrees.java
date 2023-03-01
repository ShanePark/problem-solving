package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1305AllElementsInTwoBinarySearchTrees {

    @Test
    void test() {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        List<Integer> allElements = getAllElements(root1, root2);
        assertThat(allElements).containsExactly(0, 1, 1, 2, 3, 4);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        add(root1, list);
        add(root2, list);
        list.sort(Comparator.comparingInt(integer -> integer));
        return list;
    }

    private void add(TreeNode tree, List<Integer> list) {
        if (tree == null)
            return;
        add(tree.left, list);
        list.add(tree.val);
        add(tree.right, list);
    }

}
