package shane.leetcode.problems.xhard;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FAILED
 */
public class Q968BinaryTreeCameras {

    @Test
    public void test() {
        assertThat(minCameraCover(TreeNode.ofWithNull(
                0
                , 0, 0
                , null, 0, 0, null
                , null, null, null, 0))).isEqualTo(2);
        assertThat(minCameraCover(TreeNode.ofWithNull(
                0
                , null, 0
                , null, null, null, 0
                , null, null, null, null, null, null, null, 0))).isEqualTo(2);
        assertThat(minCameraCover(TreeNode.ofWithNull(
                0,
                0, null,
                null, 0, null, null
                , null, null, 0, null, null, null, null, null
                , null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)))
                .isEqualTo(2);
        assertThat(minCameraCover(TreeNode.ofWithNull(0, 0, null, 0, 0))).isEqualTo(1);
        assertThat(minCameraCover(TreeNode.ofWithNull(0))).isEqualTo(1);
        assertThat(minCameraCover(TreeNode.ofWithNull(
                0
                , 0, null
                , 0, null, null, null
                , 0, null, null, null, null, null, null, null
                , 0))).isEqualTo(2);
    }

    public int minCameraCover(TreeNode root) {
        int answer = minCameraCover(root, false, true);
        if (root.left != null || root.right != null) {
            answer = Math.min(answer, minCameraCover(root, false, false));
        }
        return answer;
    }

    private int minCameraCover(TreeNode root, boolean hasCameraBefore, boolean hasCamera) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && !hasCameraBefore) {
            return 1;
        }
        int min = minCameraCover(root.left, hasCamera, true) + minCameraCover(root.right, hasCamera, true);
        if (hasCameraBefore || hasCamera) {
            min = Math.min(min, minCameraCover(root.left, hasCamera, false) + minCameraCover(root.right, hasCamera, false));
        }
        return (hasCamera ? 1 : 0) + min;
    }
}
