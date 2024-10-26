package shane.leetcode.problems.xhard;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2458HeightOfBinaryTreeAfterSubtreeRemovalQueries2 {

    @Test
    public void test() {
        assertThat(treeQueries(TreeNode.of(1, null, 5, 3, null, 2, 4), new int[]{3, 5, 4, 2, 4})).containsExactly(1, 0, 3, 3, 3);
        assertThat(treeQueries(TreeNode.of(5, 8, 9, 2, 1, 3, 7, 4, 6), new int[]{3, 2, 4, 8})).containsExactly(3, 2, 3, 2);
        assertThat(treeQueries(TreeNode.of(1, 3, 4, 2, null, 6, 5, null, null, null, null, null, 7), new int[]{4})).containsExactly(2);
    }

    int maxDepth;

    public int[] treeQueries(TreeNode root, int[] queries) {
        maxDepth = 0;
        int[] preOrderMax = new int[100001];
        preorder(root, 0, preOrderMax);

        maxDepth = 0;
        int[] postOrderMax = new int[100001];
        postorder(root, 0, postOrderMax);

        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.max(preOrderMax[queries[i]], postOrderMax[queries[i]]);
        }
        return answer;
    }

    private void preorder(TreeNode root, int depth, int[] preOrderMax) {
        if (root == null)
            return;
        preOrderMax[root.val] = maxDepth;
        maxDepth = Math.max(maxDepth, depth);
        preorder(root.left, depth + 1, preOrderMax);
        preorder(root.right, depth + 1, preOrderMax);
    }

    private void postorder(TreeNode root, int depth, int[] postOrderMax) {
        if (root == null)
            return;
        postOrderMax[root.val] = maxDepth;
        maxDepth = Math.max(maxDepth, depth);
        postorder(root.right, depth + 1, postOrderMax);
        postorder(root.left, depth + 1, postOrderMax);
    }

}
