package shane.leetcode.problems.xhard;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1028RecoverATreeFromPreorderTraversal {

    @Test
    public void test() {
        assertThat(recoverFromPreorder("1-2--3---4-5--6---7")).isEqualTo(TreeNode.ofWithNull(1, 2, 5, 3, null, 6, null, 4, null, null, null, 7));
        assertThat(recoverFromPreorder("1-401--349---90--88")).isEqualTo(TreeNode.ofWithNull(1, 401, null, 349, 88, null, null, 90));
        assertThat(recoverFromPreorder("1-2--3--4-5--6--7")).isEqualTo(TreeNode.ofWithNull(1, 2, 5, 3, 4, 6, 7));
        assertThat(recoverFromPreorder("1")).isEqualTo(TreeNode.ofWithNull(1));
        assertThat(recoverFromPreorder("")).isNull();
    }

    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal.isEmpty())
            return null;

        int depth = 0;
        int number = 0;
        Map<Integer, TreeNode> map = new HashMap<>();

        int i = traversal.indexOf('-');
        if (i < 0) {
            return new TreeNode(Integer.parseInt(traversal));
        }
        TreeNode root = new TreeNode(Integer.parseInt(traversal.substring(0, i)));
        map.put(0, root);

        for (; i < traversal.length(); i++) {
            char c = traversal.charAt(i);
            if (c == '-') {
                depth++;
            } else if (i < traversal.length() - 1 && traversal.charAt(i + 1) != '-') {
                number = number * 10 + (c - '0');
            } else {
                TreeNode node = new TreeNode(number * 10 + (c - '0'));
                map.put(depth, node);
                TreeNode parent = map.get(depth - 1);
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }

                depth = 0;
                number = 0;
            }
        }

        return root;
    }

}
