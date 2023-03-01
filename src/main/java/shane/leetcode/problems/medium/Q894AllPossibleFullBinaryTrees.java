package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q894AllPossibleFullBinaryTrees {

    @Test
    public void test() {
        List<TreeNode> list = allPossibleFBT(7);
        assertThat(list).hasSize(5);
        for (TreeNode treeNode : list) {
            treeNode.printTree();
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        } else if (n == 1) {
            return Arrays.asList((new TreeNode(0)));
        }

        List<TreeNode> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = l;
                    treeNode.right = r;
                    list.add(treeNode);
                }
            }
        }

        return list;
    }
}
