package shane.leetcode.contest.weekly.w320;

import io.github.shanepark.Ps;
import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * I thought it was the same logic, however it doesn't TLE
 * Runtime 249 ms Beats 25%
 * Memory 169.7 MB Beats 50%
 */
public class Q2_2 {

    @Test
    public void test() {
        TreeNode tree = TreeNode.of(6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14, null);
        assertThat(closestNodes(tree, List.of(2, 5, 16))).isEqualTo(Ps.intList("[[2,2],[4,6],[15,-1]]"));
    }

    @Test
    public void test2() {
        TreeNode tree = TreeNode.of(4, null, 9);
        assertThat(closestNodes(tree, List.of(3))).isEqualTo(Ps.intList("[[-1,4]]"));
    }

    @Test
    public void test3() {
        TreeNode tree = TreeNode.of(16, 8, 18, 1, 12, null, 20, null, 2, 9, null, null, null, null, null, null, null, null, 7);
        assertThat(closestNodes(tree, List.of(8, 14, 285508, 6))).isEqualTo(Ps.intList("[[8,8],[12,16],[20,-1],[2,7]]"));
    }

    @Test
    public void test4() {
        TreeNode tree = TreeNode.of(2, 1, null);
        assertThat(closestNodes(tree, List.of(1, 2))).isEqualTo(Ps.intList("[[1,1], [2, 2]]"));
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        dfs(root, treeSet);
        List<List<Integer>> answer = new ArrayList<>();
        for (Integer query : queries) {
            Integer first = treeSet.floor(query);
            Integer second = treeSet.ceiling(query);
            answer.add(List.of(
                    first == null ? -1 : first
                    , second == null ? -1 : second)
            );
        }
        return answer;
    }

    private void dfs(TreeNode node, TreeSet<Integer> treeSet) {
        if (node == null)
            return;
        treeSet.add(node.val);
        dfs(node.left, treeSet);
        dfs(node.right, treeSet);
    }

}
