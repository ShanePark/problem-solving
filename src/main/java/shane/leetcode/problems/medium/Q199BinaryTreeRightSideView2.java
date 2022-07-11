package shane.leetcode.problems.medium;


import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q199BinaryTreeRightSideView2 {

    @Test
    public void test() {
        assertThat(rightSideView(TreeNode.of(1, 2, 3, null, 5, null, 4))).containsExactly(1, 3, 4);
        assertThat(rightSideView(TreeNode.of(1, 2))).containsExactly(1, 2);
        assertThat(rightSideView(TreeNode.of())).containsExactly();
    }

    int maxDepth;

    public List<Integer> rightSideView(TreeNode root) {
        maxDepth = -1;
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map, 0);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            answer.add(map.get(i));
        }
        return answer;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, int depth) {
        if (root == null)
            return;
        maxDepth = Math.max(maxDepth, depth);
        map.put(depth, root.val);
        dfs(root.left, map, depth + 1);
        dfs(root.right, map, depth + 1);
    }

}
