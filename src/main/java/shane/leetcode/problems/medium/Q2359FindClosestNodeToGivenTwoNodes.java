package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 39 ms Beats 53.89%
 * Memory 50.9 MB Beats 99.40%
 */
public class Q2359FindClosestNodeToGivenTwoNodes {

    @Test
    public void test() {
        assertThat(closestMeetingNode(new int[]{4, 4, 4, 5, 1, 2, 2}, 1, 1)).isEqualTo(1);
        assertThat(closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1)).isEqualTo(2);
        assertThat(closestMeetingNode(new int[]{1, 2, -1}, 0, 2)).isEqualTo(2);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] clone = Arrays.copyOf(edges, edges.length);
        int[][] distances = new int[edges.length][2];
        for (int[] arr : distances) {
            Arrays.fill(arr, -1);
        }
        getWay(node1, clone, distances, 0);
        getWay(node2, edges, distances, 1);
        int maxDistance = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < edges.length; i++) {
            int[] distance = distances[i];
            if (distance[0] >= 0 && distance[1] >= 0) {
                int max = Math.max(distance[0], distance[1]);
                if (max < maxDistance) {
                    maxDistance = max;
                    answer = i;
                }
            }
        }
        return answer;
    }

    private static void getWay(int node, int[] edges, int[][] distances, int index) {
        int distance = 0;
        while (node != -1) {
            int cur = node;
            node = edges[cur];
            edges[cur] = -1;
            if (distances[cur][index] == -1) {
                distances[cur][index] = distance++;
            }
        }
    }

}
