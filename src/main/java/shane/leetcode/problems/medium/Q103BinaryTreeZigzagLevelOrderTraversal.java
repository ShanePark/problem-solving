package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.8 MB Beats 90.88%
 */
public class Q103BinaryTreeZigzagLevelOrderTraversal {


    @Test
    void test() {
        assertThat(zigzagLevelOrder(null)).isEmpty();
        assertThat(zigzagLevelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7)))
                .containsExactly(
                        List.of(3),
                        List.of(20, 9),
                        List.of(15, 7));
        assertThat(zigzagLevelOrder(TreeNode.of(1))).containsExactly(List.of(1));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        inOrder(root, 1, answer);
        return answer;
    }

    private void inOrder(TreeNode node, int depth, List<List<Integer>> answer) {
        if (node == null)
            return;
        if (answer.size() < depth)
            answer.add(new ArrayList<>());

        inOrder(node.left, depth + 1, answer);
        List<Integer> list = answer.get(depth - 1);
        if (depth % 2 == 1) {
            list.add(node.val);
        } else {
            list.add(0, node.val);
        }
        inOrder(node.right, depth + 1, answer);
    }

}
