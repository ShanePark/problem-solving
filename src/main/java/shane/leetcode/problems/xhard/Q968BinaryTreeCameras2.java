package shane.leetcode.problems.xhard;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q968BinaryTreeCameras2 {

    @Test
    public void test() {
        assertThat(minCameraCover(TreeNode.of(
                0
                , 0, 0
                , null, 0, 0, null
                , null, null, null, 0))).isEqualTo(2);
        assertThat(minCameraCover(TreeNode.of(
                0
                , null, 0
                , null, null, null, 0
                , null, null, null, null, null, null, null, 0))).isEqualTo(2);
        assertThat(minCameraCover(TreeNode.of(
                0,
                0, null,
                null, 0, null, null
                , null, null, 0, null, null, null, null, null
                , null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)))
                .isEqualTo(2);
        assertThat(minCameraCover(TreeNode.of(0, 0, null, 0, 0))).isEqualTo(1);
        assertThat(minCameraCover(TreeNode.of(0))).isEqualTo(1);
        assertThat(minCameraCover(TreeNode.of(
                0
                , 0, null
                , 0, null, null, null
                , 0, null, null, null, null, null, null, null
                , 0))).isEqualTo(2);
    }

    int count;

    public int minCameraCover(TreeNode root) {
        count = 0;
        if (dfs(root) == Status.NEED)
            count++;
        return count;
    }

    public Status dfs(TreeNode root) {
        if (root == null)
            return Status.SKIP;
        Status left = dfs(root.left);
        Status right = dfs(root.right);

        if (left == Status.NEED || right == Status.NEED) {
            count++;
            return Status.CAMERA;
        }
        return left == Status.CAMERA || right == Status.CAMERA ? Status.SKIP : Status.NEED;
    }

    enum Status {
        CAMERA, NEED, SKIP
    }
}
