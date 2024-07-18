package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime99msBeats5.93%
 */
public class Q1530NumberOfGoodLeafNodesPairs {

    @Test
    public void test() {
        assertThat(countPairs(TreeNode.of(1, 2, 3, null, 4), 3)).isEqualTo(1);
        assertThat(countPairs(TreeNode.of(1, 2, 3, 4, 5, 6, 7), 3)).isEqualTo(2);
        assertThat(countPairs(TreeNode.of(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2), 3))
                .isEqualTo(1);
    }

    public int countPairs(TreeNode root, int distance) {
        int answer = 0;
        if (root == null)
            return answer;
        Map<Integer, Integer> leftCnt = countLeaf(root.left, 1);
        Map<Integer, Integer> rightCnt = countLeaf(root.right, 1);
        List<Integer> leftDistances = leftCnt.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> rightDistances = rightCnt.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer leftDistance : leftDistances) {
            for (Integer rightDistance : rightDistances) {
                if (leftDistance + rightDistance > distance)
                    break;
                answer += leftCnt.get(leftDistance) * rightCnt.get(rightDistance);
            }
        }
        answer += countPairs(root.left, distance);
        answer += countPairs(root.right, distance);
        return answer;
    }

    private Map<Integer, Integer> countLeaf(TreeNode node, int distance) {
        if (node == null)
            return new HashMap<>();
        if (node.left == null && node.right == null) {
            Map<Integer, Integer> answer = new HashMap<>();
            answer.put(distance, 1);
            return answer;
        }
        Map<Integer, Integer> left = countLeaf(node.left, distance + 1);
        Map<Integer, Integer> right = countLeaf(node.right, distance + 1);
        for (Map.Entry<Integer, Integer> e : right.entrySet()) {
            left.merge(e.getKey(), e.getValue(), Integer::sum);
        }
        return left;
    }

}
