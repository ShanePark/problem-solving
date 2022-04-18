package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q230KthSmallestElementInABST {

    @Test
    public void test() {
        assertThat(kthSmallest(TreeNode.of(new Integer[]{3, 1, 4, null, 2}), 1)).isEqualTo(1);
        assertThat(kthSmallest(TreeNode.of(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3)).isEqualTo(3);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = traverse(root);
        return list.get(k - 1);
    }

    private List<Integer> traverse(TreeNode node) {
        if (node == null)
            return Collections.EMPTY_LIST;
        List<Integer> list = new ArrayList<>();
        list.addAll(traverse(node.left));
        list.add(node.val);
        list.addAll(traverse(node.right));
        return list;
    }


}
