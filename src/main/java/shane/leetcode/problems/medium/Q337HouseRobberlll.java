package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;

public class Q337HouseRobberlll {
    public static void main(String[] args) {
        TreeNode t = TreeNode.of(new Integer[]{3, 2, 3, null, 3, null, 1});
        Assertions.assertEquals(7, rob(t));
        TreeNode t2 = TreeNode.of(new Integer[]{3, 4, 5, 1, 3, null, 1});
        Assertions.assertEquals(9, rob(t2));
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

}
