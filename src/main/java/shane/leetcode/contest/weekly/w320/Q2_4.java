package shane.leetcode.contest.weekly.w320;

import io.github.shanepark.Ps;
import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 192 ms Beats 50%
 * Memory 170.9 MB Beats 50%
 */
public class Q2_4 {

    @Test
    public void test() {
        assertThat(closestNodes(TreeNode.of(2, 1, null), List.of(1, 2))).isEqualTo(Ps.intList("[[1,1], [2, 2]]"));
        assertThat(closestNodes(TreeNode.of(16, 8, 18, 1, 12, null, 20, null, 2, 9, null, null, null, null, null, null, null, null, 7), List.of(8, 14, 285508, 6))).isEqualTo(Ps.intList("[[8,8],[12,16],[20,-1],[2,7]]"));
        assertThat(closestNodes(TreeNode.of(6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14, null), List.of(2, 5, 16))).isEqualTo(Ps.intList("[[2,2],[4,6],[15,-1]]"));
        assertThat(closestNodes(TreeNode.of(4, null, 9), List.of(3))).isEqualTo(Ps.intList("[[-1,4]]"));
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();
        traverse(root, sortedList);
        for (Integer query : queries) {
            answer.add(List.of(LargestSmallerOrEqual(sortedList, query), smallestGreaterOrEqual(sortedList, query)));
        }
        return answer;
    }

    private int smallestGreaterOrEqual(List<Integer> sorted, Integer query) {
        int right = sorted.size() - 1;
        if (sorted.get(right) < query)
            return -1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = sorted.get(mid);
            if (val == query)
                return val;
            if (val < query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return sorted.get(left);
    }

    private int LargestSmallerOrEqual(List<Integer> sorted, Integer query) {
        int left = 0;
        int right = sorted.size() - 1;
        if (sorted.get(left) > query)
            return -1;
        if (sorted.get(right) < query)
            return sorted.get(right);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = sorted.get(mid);
            if (val == query)
                return val;
            if (val < query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        Integer answer = (sorted.get(left) <= query) ? sorted.get(left) : sorted.get(left - 1);
        return answer;
    }

    private void traverse(TreeNode root, List<Integer> sortedList) {
        if (root == null)
            return;
        traverse(root.left, sortedList);
        sortedList.add(root.val);
        traverse(root.right, sortedList);
    }

}
