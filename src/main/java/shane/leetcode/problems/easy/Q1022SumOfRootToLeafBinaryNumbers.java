package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q1022SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(node));
    }

    public static int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        process(root, list, "");
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s, 2);
        }
        return sum;
    }

    private static void process(TreeNode root, List<String> list, String str) {
        str = str + root.val;
        if (root.left == null && root.right == null) {
            list.add(str);
            return;
        }

        if (root.left != null) {
            process(root.left, list, str);
        }
        if (root.right != null) {
            process(root.right, list, str);
        }

    }

}
