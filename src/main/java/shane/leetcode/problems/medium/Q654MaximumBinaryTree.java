package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q654MaximumBinaryTree {

    @Test
    void test() {
        TreeNode root = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        root.printTree();
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode tree = new TreeNode(max);
        tree.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        tree.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        return tree;
    }
}
