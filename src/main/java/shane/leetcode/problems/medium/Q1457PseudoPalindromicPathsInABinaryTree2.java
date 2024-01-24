package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 10 ms Beats 82.21% of users with Java
 */
public class Q1457PseudoPalindromicPathsInABinaryTree2 {

    @Test
    public void test() {
        assertThat(pseudoPalindromicPaths(TreeNode.of(2, 3, 1, 3, 1, null, 1))).isEqualTo(2);
        assertThat(pseudoPalindromicPaths(TreeNode.of(2, 1, 1, 1, 3, null, null, null, null, null, 1))).isEqualTo(1);
        assertThat(pseudoPalindromicPaths(TreeNode.of(9))).isEqualTo(1);
    }

    int cnt = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        cnt = 0;
        int[] arr = new int[10];
        dfs(root, arr);
        return cnt;
    }

    private void dfs(TreeNode node, int[] arr) {
        if (node == null)
            return;
        arr[node.val]++;
        if (node.left == null && node.right == null) {
            checkPalindrome(arr);
        } else {
            dfs(node.left, arr);
            dfs(node.right, arr);
        }
        arr[node.val]--;
    }

    private void checkPalindrome(int[] arr) {
        boolean odd = false;
        for (int i : arr) {
            if (i % 2 != 0) {
                if (odd)
                    return;
                odd = true;
            }
        }
        cnt++;
    }

}
