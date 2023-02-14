package shane.leetcode.contest.weekly.w292;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(averageOfSubtree(TreeNode.ofWithNull(4, 8, 5, 0, 1, null, 6))).isEqualTo(5);
        assertThat(averageOfSubtree(TreeNode.ofWithNull(1))).isEqualTo(1);
    }

    Map<TreeNode, TreeSum> map;

    public int averageOfSubtree(TreeNode root) {
        map = new HashMap<>();
        process(root);
        int cnt = 0;
        for (Map.Entry<TreeNode, TreeSum> entry : map.entrySet()) {
            TreeNode node = entry.getKey();
            TreeSum treeSum = entry.getValue();
            if (node.val == treeSum.totalSum / treeSum.totalCount) {
                cnt++;
            }
        }
        return cnt;
    }

    private TreeSum process(TreeNode node) {
        if (node == null) {
            return new TreeSum(0, 0);
        }
        TreeSum left = process(node.left);
        TreeSum right = process(node.right);
        TreeSum treeSum = new TreeSum(left.totalCount + right.totalCount + 1, node.val + left.totalSum + right.totalSum);
        map.put(node, treeSum);
        return treeSum;
    }

    class TreeSum {
        int totalCount;
        int totalSum;

        public TreeSum(int totalCount, int totalSum) {
            this.totalCount = totalCount;
            this.totalSum = totalSum;
        }

        @Override
        public String toString() {
            return "TreeSum{" +
                    "totalCount=" + totalCount +
                    ", totalSum=" + totalSum +
                    '}';
        }
    }


}
