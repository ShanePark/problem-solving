package shane.leetcode.problems.xhard;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 * 37 / 40 testcases passed
 */
public class Q2458HeightOfBinaryTreeAfterSubtreeRemovalQueries {

    @Test
    public void test() {
        assertThat(treeQueries(TreeNode.of(1, null, 5, 3, null, 2, 4), new int[]{3, 5, 4, 2, 4})).containsExactly(1, 0, 3, 3, 3);
        assertThat(treeQueries(TreeNode.of(5, 8, 9, 2, 1, 3, 7, 4, 6), new int[]{3, 2, 4, 8})).containsExactly(3, 2, 3, 2);
        assertThat(treeQueries(TreeNode.of(1, 3, 4, 2, null, 6, 5, null, null, null, null, null, 7), new int[]{4})).containsExactly(2);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Map<TreeNode, Map<Integer, Integer>> subCountsByDepth = new HashMap<>();
        traverse(root, nodeMap, subCountsByDepth, 0);

        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);
        Map<Integer, Integer> rootDepthMap = subCountsByDepth.get(root);
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            TreeNode nodeToRemove = nodeMap.get(query);
            Map<Integer, Integer> depthMap = subCountsByDepth.get(nodeToRemove);
            List<Integer> depths = rootDepthMap.keySet().stream()
                    .sorted()
                    .collect(Collectors.toList());
            for (Integer depth : depths) {
                int original = rootDepthMap.get(depth);
                int nodeDepth = depthMap.getOrDefault(depth, 0);
                if (original == nodeDepth) {
                    answer[i] = depth - 1;
                    break;
                }
            }
            if (answer[i] == -1) {
                answer[i] = depths.get(depths.size() - 1);
            }
        }

        return answer;
    }

    private Map<Integer, Integer> traverse(TreeNode node, Map<Integer, TreeNode> nodeMap, Map<TreeNode, Map<Integer, Integer>> subCountsByDepth, int depth) {
        if (node == null)
            return new HashMap<>();
        nodeMap.put(node.val, node);
        Map<Integer, Integer> depthMap = new HashMap<>();
        depthMap.put(depth, 1);

        Map<Integer, Integer> left = traverse(node.left, nodeMap, subCountsByDepth, depth + 1);
        Map<Integer, Integer> right = traverse(node.right, nodeMap, subCountsByDepth, depth + 1);

        for (Map.Entry<Integer, Integer> e : left.entrySet()) {
            depthMap.merge(e.getKey(), e.getValue(), Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : right.entrySet()) {
            depthMap.merge(e.getKey(), e.getValue(), Integer::sum);
        }

        subCountsByDepth.put(node, depthMap);
        return depthMap;
    }

}
