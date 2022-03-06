package shane.leetcode.contest.weekly.w283;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// TODO Stool couldn't be used for Q3 int array
public class Q2196CreateBinaryTreeFromDescriptions {

    @Test
    void test() {
        TreeNode tree = createBinaryTree(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
        tree.printTree();
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int[] description : descriptions) {
            TreeNode node = map.getOrDefault(description[0], new TreeNode(description[0]));
            TreeNode child = map.getOrDefault(description[1], new TreeNode(description[1]));
            if (description[2] == 1) {
                node.left = child;
            } else {
                node.right = child;
            }
            parentMap.put(description[1], description[0]);
            map.putIfAbsent(description[0], node);
            map.putIfAbsent(description[1], child);
        }

        TreeNode tree = map.get(descriptions[0][0]);
        while (parentMap.get(tree.val) != null) {
            tree = map.get(parentMap.get(tree.val));
        }
        return tree;
    }

}
