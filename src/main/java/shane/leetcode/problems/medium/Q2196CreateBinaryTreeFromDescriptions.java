package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime72msBeats39.07%
 */
public class Q2196CreateBinaryTreeFromDescriptions {

    @Test
    public void test() {
        assertThat(createBinaryTree(Ps.intArray("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]")))
                .isEqualTo(TreeNode.of(50, 20, 80, 15, 17, 19));
        assertThat(createBinaryTree(Ps.intArray("[[1,2,1],[2,3,0],[3,4,1]]")))
                .isEqualTo(TreeNode.of(1, 2, null, null, 3, 4));
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] description : descriptions) {
            map.put(description[0], new TreeNode(description[0]));
            map.put(description[1], new TreeNode(description[1]));
            children.add(description[1]);
        }
        for (int[] description : descriptions) {
            TreeNode parent = map.get(description[0]);
            TreeNode child = map.get(description[1]);
            if (description[2] == 1) {
                parent.left = child;
                continue;
            }
            parent.right = child;
        }
        return map.keySet().stream()
                .filter(k -> !children.contains(k))
                .findFirst()
                .map(map::get)
                .get();
    }

}
