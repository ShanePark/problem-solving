package shane.leetcode.contest.weekly.w304;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q3_2 {

    @Test
    public void test() {
        assertThat(closestMeetingNode(new int[]{5, 4, 5, 4, 3, 6, -1}, 0, 1)).isEqualTo(-1);
        assertThat(closestMeetingNode(new int[]{2, 0, 0}, 2, 0)).isEqualTo(0);
        assertThat(closestMeetingNode(new int[]{4, 4, 4, 5, 1, 2, 2}, 1, 1)).isEqualTo(1);
        assertThat(closestMeetingNode(new int[]{4, 3, 0, 5, 3, -1}, 4, 0)).isEqualTo(4);
        assertThat(closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1)).isEqualTo(2);
        assertThat(closestMeetingNode(new int[]{1, 2, -1}, 0, 2)).isEqualTo(2);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int res = -1;
        int min_dist = Integer.MAX_VALUE;

        int[] m1 = new int[edges.length];
        int[] m2 = new int[edges.length];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);

        for (int i = node1, dist = 0; i != -1 && m1[i] == -1; i = edges[i]) {
            m1[i] = dist++;
        }
        for (int i = node2, dist = 0; i != -1 && m2[i] == -1; i = edges[i]) {
            m2[i] = dist++;
            if (m1[i] >= 0 && Math.max(m1[i], m2[i]) <= min_dist) {
                res = (Math.max(m1[i], m2[i]) == min_dist) ? Math.min(res, i) : i;
                min_dist = Math.max(m1[i], m2[i]);
            }
        }
        return res;
    }

}
