package shane.leetcode.problems.medium;


import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q199BinaryTreeRightSideView {

    @Test
    public void test() {
        assertThat(rightSideView(TreeNode.ofWithNull(1, 2, 3, null, 5, null, 4))).containsExactly(1, 3, 4);
        assertThat(rightSideView(TreeNode.ofWithNull(1, 2))).containsExactly(1, 2);
        assertThat(rightSideView(TreeNode.ofWithNull())).containsExactly();
    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map, 0);
        List<Integer> answer = new ArrayList<>();
        map.keySet().stream().sorted().forEach(depth -> {
            List<Integer> list = map.get(depth);
            answer.add(list.get(list.size() - 1));
        });
        return answer;
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int depth) {
        if (root == null)
            return;
        List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
        list.add(root.val);
        map.put(depth, list);
        dfs(root.left, map, depth + 1);
        dfs(root.right, map, depth + 1);
    }
}
