package shane.leetcode.problems.xhard;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5
 * ms
 * Beats
 * 64.47%
 */
public class Q1028RecoverATreeFromPreorderTraversal2 {

    @Test
    public void test() {
        assertThat(recoverFromPreorder("1-2--3---4-5--6---7")).isEqualTo(TreeNode.of(1, 2, 5, 3, null, 6, null, 4, null, 7));
        assertThat(recoverFromPreorder("1-2--3--4-5--6--7")).isEqualTo(TreeNode.of(1, 2, 5, 3, 4, 6, 7));
        assertThat(recoverFromPreorder("1-401--349---90--88")).isEqualTo(TreeNode.of(1, 401, null, 349, 88, 90));
    }

    public TreeNode recoverFromPreorder(String traversal) {
        List<int[]> list = parse(traversal); // [value, depth]
        Map<Integer, TreeNode> depthNode = new HashMap<>();
        TreeNode root = new TreeNode(list.get(0)[0]);
        depthNode.put(0, root);
        for (int i = 1; i < list.size(); i++) {
            int[] data = list.get(i);
            int depth = data[1];
            TreeNode node = new TreeNode(data[0]);
            TreeNode parent = depthNode.get(depth - 1);
            depthNode.put(depth, node);
            if (parent.left == null) {
                parent.left = node;
                continue;
            }
            parent.right = node;
        }
        return root;
    }

    private List<int[]> parse(String traversal) {
        List<int[]> list = new ArrayList<>();
        int depth = 0;
        int n = 0;
        for (char c : traversal.toCharArray()) {
            if (c == '-') {
                if (n == 0) {
                    depth++;
                    continue;
                }
                list.add(new int[]{n, depth});
                n = 0;
                depth = 1;
                continue;
            }
            n = n * 10 + (c - '0');
        }
        list.add(new int[]{n, depth});
        return list;
    }

}
