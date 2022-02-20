package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q938RangeSumofBST {

    @Test
    void test() {
        Assertions.assertThat(rangeSumBST(TreeNode.makeTree(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15)).isEqualTo(32);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return 0;
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.makeTree(new Integer[]{10, 5, 15, null, null, null, 18});
        TreeNode root = TreeNode.makeTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
        root.printTree();
    }


}
