package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q979DistributeCoinsInBinaryTree {

    @Test
    public void test() {
        assertThat(distributeCoins(TreeNode.of(0, 3, 0))).isEqualTo(3);
        assertThat(distributeCoins(TreeNode.of(3, 0, 0))).isEqualTo(2);
    }

    int cnt;

    public int distributeCoins(TreeNode root) {
        cnt = 0;
        required(root);
        return cnt;
    }

    private int required(TreeNode node) {
        if (node == null)
            return 0;
        int required = required(node.left) + required(node.right) + 1 - node.val;
        cnt += Math.abs(required);
        return required;
    }
}
