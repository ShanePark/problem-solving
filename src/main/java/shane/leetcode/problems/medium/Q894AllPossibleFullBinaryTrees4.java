package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 98.93%
 * Memory 45.6 MB Beats 80.92%
 */
public class Q894AllPossibleFullBinaryTrees4 {

    @Test
    public void test() {
        assertThat(allPossibleFBT(19)).hasSize(4862);
        assertThat(allPossibleFBT(7)).hasSize(5);
        assertThat(allPossibleFBT(3)).hasSize(1);
    }

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        }
        if (n == 1)
            return List.of(new TreeNode());
        if (map.containsKey(n))
            return map.get(n);

        List<TreeNode> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(n - 1 - i);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode();
                    node.left = left;
                    node.right = right;
                    answer.add(node);
                }
            }
        }

        map.put(n, answer);
        return answer;
    }

}
