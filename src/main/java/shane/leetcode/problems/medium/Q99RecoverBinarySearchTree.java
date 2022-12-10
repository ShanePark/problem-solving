package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q99RecoverBinarySearchTree {

    @Test
    public void test() {
        TreeNode root = TreeNode.ofWithNull(1, 3, null, null, 2);
        recoverTree(root);
        assertThat(root).isEqualTo(TreeNode.ofWithNull(3, 1, null, null, 2));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.ofWithNull(3, 1, 4, null, null, 2);
        recoverTree(root);
        assertThat(root).isEqualTo(TreeNode.ofWithNull(2, 1, 4, null, null, 3));
    }

    public void recoverTree(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        traverse(root, numbers, indexes, 0);
        Collections.sort(numbers);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            map.put(indexes.get(i), numbers.get(i));
        }

        Collections.sort(indexes);
        TreeNode answer = new TreeNode(map.get(0));
        Map<Integer, TreeNode> treeMap = new HashMap<>();
        treeMap.put(0, answer);

        for (int i = 1; i < indexes.size(); i++) {
            Integer index = indexes.get(i);
            TreeNode tree = new TreeNode(map.get(index));
            treeMap.put(index, tree);
            TreeNode parent = treeMap.get((index - 1) / 2);
            if (index % 2 == 0) {
                parent.right = tree;
            } else {
                parent.left = tree;
            }
        }

        root.val = answer.val;
        root.left = answer.left;
        root.right = answer.right;
    }

    private void traverse(TreeNode root, List<Integer> list, List<Integer> indexes, int index) {
        if (root == null)
            return;
        traverse(root.left, list, indexes, index * 2 + 1);
        list.add(root.val);
        indexes.add(index);
        traverse(root.right, list, indexes, index * 2 + 2);
    }

}
