package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class Q337HouseRobberlll {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(new Integer[]{3, 2, 3, null, 3, null, 1});
        Assertions.assertEquals(7, rob(t));
        TreeNode t2 = new TreeNode(new Integer[]{4, 1, null, 2, null, 3});
        Assertions.assertEquals(7, rob(t2));
    }

    public static int rob(TreeNode root) {
        Result r = robHouse(root);
        return r.max;
    }

    public static Result robHouse(TreeNode root) {
        if (root == null)
            return new Result(0, 0);
        Result left = robHouse(root.left);
        Result right = robHouse(root.right);

        return new Result(
                Math.max(left.sumWithoutSelf, left.SumWithSelf) + Math.max(right.sumWithoutSelf, right.SumWithSelf)
                , root.val + left.sumWithoutSelf + right.sumWithoutSelf);
    }

    static class Result {
        int sumWithoutSelf;
        int SumWithSelf;
        int max;

        Result(int sumWithoutSelf, int SumWithSelf) {
            this.sumWithoutSelf = sumWithoutSelf;
            this.SumWithSelf = SumWithSelf;
            this.max = Math.max(sumWithoutSelf, SumWithSelf);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer[] arr) {
            if (arr.length % 2 == 0) {
                Integer[] arr2 = new Integer[arr.length + 1];
                arr2[0] = 0;
                for (int i = 0; i < arr.length; i++) {
                    arr2[i + 1] = arr[i];
                }
                arr = arr2;
            }
            List<TreeNode> list = new ArrayList<>();
            this.val = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    list.add(new TreeNode(arr[i]));
                } else {
                    list.add(new TreeNode(0));
                }
            }
            this.left = list.get(1);
            this.right = list.get(2);
            for (int i = 3; i < arr.length; i++) {
                if (i % 2 == 0) {
                    list.get((i - 1) / 2).right = list.get(i);
                } else {
                    list.get((i - 1) / 2).left = list.get(i);
                }
            }
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}