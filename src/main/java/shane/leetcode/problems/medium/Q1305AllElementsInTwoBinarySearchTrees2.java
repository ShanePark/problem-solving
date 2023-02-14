package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1305AllElementsInTwoBinarySearchTrees2 {

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
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        add(root1, list1);
        add(root2, list2);

        List<Integer> answer = new ArrayList<>();
        int i1, i2;
        for (i1 = 0, i2 = 0; i1 < list1.size() && i2 < list2.size(); ) {
            if (list1.get(i1) > list2.get(i2)) {
                answer.add(list2.get(i2++));
            } else {
                answer.add(list1.get(i1++));
            }
        }
        if (i1 < list1.size()) {
            answer.addAll(list1.subList(i1, list1.size()));
        } else {
            answer.addAll(list2.subList(i2, list2.size()));
        }
        return answer;
    }

    private void add(TreeNode tree, List<Integer> list) {
        if (tree == null)
            return;
        add(tree.left, list);
        list.add(tree.val);
        add(tree.right, list);
    }

}
