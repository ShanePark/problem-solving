package shane.leetcode.contest.weekly.w320;

import com.github.shanepark.Ps;
import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE (Hidden)
 */
public class Q2 {

    @Test
    public void test() {
        TreeNode tree = TreeNode.ofWithNull(6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14, null);
        assertThat(closestNodes(tree, List.of(2, 5, 16))).isEqualTo(Ps.intList("[[2,2],[4,6],[15,-1]]"));
    }

    @Test
    public void test2() {
        TreeNode tree = TreeNode.ofWithNull(4, null, 9);
        assertThat(closestNodes(tree, List.of(3))).isEqualTo(Ps.intList("[[-1,4]]"));
    }

    @Test
    public void test3() {
        TreeNode tree = TreeNode.ofWithNull(16, 8, 18, 1, 12, null, 20, null, 2, 9, null, null, null, null, null, null, null, null, 7);
        assertThat(closestNodes(tree, List.of(8, 14, 285508, 6))).isEqualTo(Ps.intList("[[8,8],[12,16],[20,-1],[2,7]]"));
    }

    @Test
    public void test4() {
        TreeNode tree = TreeNode.ofWithNull(2, 1, null);
        assertThat(closestNodes(tree, List.of(1, 2))).isEqualTo(Ps.intList("[[1,1], [2, 2]]"));
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> answer = new ArrayList<>();
        for (Integer query : queries) {
            answer.add(List.of(smallerOrEqual(root, query), greaterOrEqual(root, query)));
        }
        return answer;
    }

    private int smallerOrEqual(TreeNode node, Integer query) {
        if (node == null)
            return -1;
        if (node.val == query) {
            return node.val;
        }
        if (node.val > query) {
            return smallerOrEqual(node.left, query);
        }
        if (node.right == null || smallerOrEqual(node.right, query) == -1) {
            return node.val;
        }
        return smallerOrEqual(node.right, query);
    }

    private int greaterOrEqual(TreeNode node, Integer query) {
        if (node == null)
            return -1;
        if (node.val == query) {
            return node.val;
        }
        if (node.val > query) {
            if (node.left == null || greaterOrEqual(node.left, query) == -1)
                return node.val;
            return greaterOrEqual(node.left, query);
        }
        return greaterOrEqual(node.right, query);
    }

}
