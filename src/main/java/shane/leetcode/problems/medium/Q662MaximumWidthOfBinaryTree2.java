package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q662MaximumWidthOfBinaryTree2 {

    @Test
    void test() {
        Assertions.assertThat(widthOfBinaryTree(TreeNode.ofWithNull(new Integer[]{1, 3, 2, 5, 3, null, 9}))).isEqualTo(4);
        Assertions.assertThat(widthOfBinaryTree(TreeNode.ofWithNull(new Integer[]{1, 3, null, 5, 3}))).isEqualTo(2);
        Assertions.assertThat(widthOfBinaryTree(TreeNode.ofWithNull(new Integer[]{1, 3, 2, 5}))).isEqualTo(2);
//        Assertions.assertThat(widthOfBinaryTree(TreeNode.ofWithNull(new Integer[]{1, 3, 2, 5, 0, null, 9, 6, null, null, 7}))).isEqualTo(8);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Map<Integer, MinMaxPair> map = new HashMap<>();

        dfs(root, map, 0, 0);

        int max = 0;
        for (MinMaxPair minMaxPair : map.values()) {
            if (minMaxPair.min != null && minMaxPair.max != null) {
                max = Math.max(max, minMaxPair.max - minMaxPair.min + 1);
            }
        }

        return max;

    }

    private void dfs(TreeNode root, Map<Integer, MinMaxPair> map, int num, int depth) {
        if (root == null)
            return;
        MinMaxPair minMaxPair = map.getOrDefault(depth, new MinMaxPair());
        if (minMaxPair.min == null || minMaxPair.min > num) {
            minMaxPair.min = num;
        }
        if (minMaxPair.max == null || minMaxPair.max < num) {
            minMaxPair.max = num;
        }
        map.put(depth, minMaxPair);

        dfs(root.left, map, num * 2 + 1, depth + 1);
        dfs(root.right, map, num * 2 + 2, depth + 1);

    }


    static class MinMaxPair {
        Integer min;
        Integer max;

        @Override
        public String toString() {
            return "MinMaxPair{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}
