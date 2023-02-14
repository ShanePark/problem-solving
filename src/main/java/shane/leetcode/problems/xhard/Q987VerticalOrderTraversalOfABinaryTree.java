package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 11 ms, faster than 5.64% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 * Memory Usage: 43.6 MB, less than 10.67% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 */
public class Q987VerticalOrderTraversalOfABinaryTree {

    @Test
    public void test() {
        assertThat(verticalTraversal(TreeNode.ofWithNull(3, 1, 4, 0, 2, 2))).isEqualTo(Ps.intList("[[0],[1],[3,2,2],[4]]"));
        assertThat(verticalTraversal(TreeNode.ofWithNull(3, 9, 20, null, null, 15, 7))).isEqualTo(Ps.intList("[[9],[3,15],[20],[7]]"));
        assertThat(verticalTraversal(TreeNode.ofWithNull(1, 2, 3, 4, 5, 6, 7))).isEqualTo(Ps.intList("[[4],[2],[1,5,6],[3],[7]]"));
        assertThat(verticalTraversal(TreeNode.ofWithNull(1, 2, 3, 4, 6, 5, 7))).isEqualTo(Ps.intList("[[4],[2],[1,5,6],[3],[7]]"));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Obj>> map = new HashMap<>();
        dfs(root, 0, 0, map);

        return map.entrySet().stream()
                .sorted((Comparator.comparingInt(Map.Entry::getKey)))
                .map(e -> e.getValue().stream()
                        .sorted()
                        .map(v -> v.value)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private void dfs(TreeNode node, int i, int depth, Map<Integer, List<Obj>> map) {
        if (node == null)
            return;
        List<Obj> list = map.getOrDefault(i, new ArrayList<>());
        map.put(i, list);

        list.add(new Obj(depth, node.val));
        dfs(node.left, i - 1, depth + 1, map);
        dfs(node.right, i + 1, depth + 1, map);
    }

    class Obj implements Comparable {
        int depth;
        int value;

        public Obj(int depth, int value) {
            this.depth = depth;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Obj o1 = (Obj) o;
            if (this.depth == o1.depth) {
                return Integer.compare(this.value, o1.value);
            }
            return Integer.compare(this.depth, o1.depth);
        }
    }

}
