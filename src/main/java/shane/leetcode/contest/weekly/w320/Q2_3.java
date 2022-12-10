package shane.leetcode.contest.weekly.w320;

import com.tistory.shanepark.STool;
import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE... (36/37 case)
 * for extremely unbalanced case it become O(n) search
 */
public class Q2_3 {

    @Test
    public void test2() {
        TreeNode tree = TreeNode.ofWithNull(4, null, 9);
        assertThat(closestNodes(tree, List.of(3))).isEqualTo(STool.convertToIntList("[[-1,4]]"));
    }

    @Test
    public void test3() {
        TreeNode tree = TreeNode.ofWithNull(16, 8, 18, 1, 12, null, 20, null, 2, 9, null, null, null, null, null, null, null, null, 7);
        assertThat(closestNodes(tree, List.of(8, 14, 285508, 6))).isEqualTo(STool.convertToIntList("[[8,8],[12,16],[20,-1],[2,7]]"));
    }

    @Test
    public void test4() {
        TreeNode tree = TreeNode.ofWithNull(2, 1, null);
        assertThat(closestNodes(tree, List.of(1, 2))).isEqualTo(STool.convertToIntList("[[1,1], [2, 2]]"));
    }

    @Test
    public void test() {
        TreeNode tree = TreeNode.ofWithNull(6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14, null);
        assertThat(closestNodes(tree, List.of(2, 5, 16))).isEqualTo(STool.convertToIntList("[[2,2],[4,6],[15,-1]]"));
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> answer = new ArrayList<>();
        for (Integer query : queries) {
            answer.add(List.of(LargestSmallerOrEqual(root, query, -1), smallestGreaterOrEqual(root, query, -1)));
        }
        return answer;
    }

    private int LargestSmallerOrEqual(TreeNode node, Integer query, Integer saved) {
        if (node == null)
            return saved;
        if (node.val == query)
            return node.val;
        if (node.val > query) {
            return LargestSmallerOrEqual(node.left, query, saved);
        }
        return LargestSmallerOrEqual(node.right, query, Math.max(node.val, saved));
    }

    private int smallestGreaterOrEqual(TreeNode node, Integer query, Integer saved) {
        if (node == null)
            return saved;
        if (node.val == query)
            return node.val;
        if (node.val < query) {
            return smallestGreaterOrEqual(node.right, query, saved);
        }
        return smallestGreaterOrEqual(node.left, query, saved == -1 ? node.val : Math.min(saved, node.val));
    }

}
