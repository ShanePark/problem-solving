package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
21ms
Beats33.57%
 */
public class Q2359FindClosestNodeToGivenTwoNodes2 {

    @Test
    public void test() {
        assertThat(closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1)).isEqualTo(2);
        assertThat(closestMeetingNode(new int[]{1, 2, -1}, 0, 2)).isEqualTo(2);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Integer[] node1Distance = getNodeDistance(edges, node1);
        Integer[] node2Distance = getNodeDistance(edges, node2);
        int answer = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (node1Distance[i] == null || node2Distance[i] == null)
                continue;
            int cur = Math.max(node1Distance[i], node2Distance[i]);
            if (distance <= cur)
                continue;
            answer = i;
            distance = cur;
        }
        return answer;
    }

    private Integer[] getNodeDistance(int[] edges, int node) {
        Integer[] answer = new Integer[edges.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                if (answer[poll] != null)
                    continue;
                answer[poll] = distance;
                if (edges[poll] == -1)
                    continue;
                q.offer(edges[poll]);
            }
            distance++;
        }
        return answer;
    }

}
