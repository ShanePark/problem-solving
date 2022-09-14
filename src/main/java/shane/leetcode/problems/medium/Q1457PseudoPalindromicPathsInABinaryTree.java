package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 96 ms, faster than 22.22% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
 * Memory Usage: 175.1 MB, less than 11.11% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
 */
public class Q1457PseudoPalindromicPathsInABinaryTree {

    @Test
    public void test() {
        assertThat(pseudoPalindromicPaths(TreeNode.of(2, 3, 1, 3, 1, null, 1))).isEqualTo(2);
    }

    int cnt;

    public int pseudoPalindromicPaths(TreeNode root) {
        cnt = 0;
        dfs(root, new Status(new int[10]));
        return cnt;
    }

    private void dfs(TreeNode node, Status status) {
        if (node.left == null && node.right == null) {
            status.arr[node.val]++;
            int cntOdd = 0;
            for (int i : status.arr) {
                if (i % 2 == 1)
                    cntOdd++;
            }
            if (cntOdd <= 1) {
                cnt++;
            }
            return;
        }
        if (node.left != null) {
            Status left = new Status(status.arr);
            left.arr[node.val]++;
            dfs(node.left, left);
        }
        if (node.right != null) {
            Status right = new Status(status.arr);
            right.arr[node.val]++;
            dfs(node.right, right);
        }
    }

    class Status {
        int[] arr;

        public Status(int[] arr) {
            this.arr = Arrays.copyOf(arr, arr.length);
        }
    }

}
