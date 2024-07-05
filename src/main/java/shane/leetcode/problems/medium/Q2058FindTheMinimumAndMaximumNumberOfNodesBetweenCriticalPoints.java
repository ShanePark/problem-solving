package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime28msBeats7.69%
 */
public class Q2058FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    @Test
    public void test() {
        assertThat(nodesBetweenCriticalPoints(ListNode.of(2, 2, 1, 3))).containsExactly(-1, -1);
        assertThat(nodesBetweenCriticalPoints(ListNode.of(3, 1))).containsExactly(-1, -1);
        assertThat(nodesBetweenCriticalPoints(ListNode.of(5, 3, 1, 2, 5, 1, 2))).containsExactly(1, 3);
        assertThat(nodesBetweenCriticalPoints(ListNode.of(1, 3, 2, 2, 3, 2, 2, 2, 7))).containsExactly(3, 3);
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = tolist(head);
        List<Integer> criticalPoints = new ArrayList<>();
        for (int i = 1; i < list.size() - 1; i++) {
            int cur = list.get(i);
            if ((cur < list.get(i - 1) && cur < list.get(i + 1)) || cur > list.get(i - 1) && cur > list.get(i + 1)) {
                criticalPoints.add(i);
            }
        }
        if (criticalPoints.size() <= 1) {
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < criticalPoints.size(); i++) {
            min = Math.min(min, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }
        int max = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        return new int[]{min, max};
    }

    private List<Integer> tolist(ListNode head) {
        List<Integer> answer = new ArrayList<>();
        while (head != null) {
            answer.add(head.val);
            head = head.next;
        }
        return answer;
    }

}
