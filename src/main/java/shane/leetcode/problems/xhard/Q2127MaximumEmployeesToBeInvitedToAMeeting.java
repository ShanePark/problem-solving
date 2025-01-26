package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2127MaximumEmployeesToBeInvitedToAMeeting {

    @Test
    public void test() {
        assertThat(maximumInvitations(new int[]{2, 2, 1, 2})).isEqualTo(3);
        assertThat(maximumInvitations(new int[]{1, 2, 0})).isEqualTo(3);
        assertThat(maximumInvitations(new int[]{3, 0, 1, 4, 1})).isEqualTo(4);
        assertThat(maximumInvitations(new int[]{1, 0, 3, 2})).isEqualTo(4);
        assertThat(maximumInvitations(new int[]{1, 2, 3, 4, 2})).isEqualTo(3);
    }

    public int maximumInvitations(int[] favorite) {
        final int LENGTH = favorite.length;
        List<Integer>[] neighbors = new List[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            neighbors[i] = new ArrayList<>();
        }
        for (int i = 0; i < LENGTH; i++) {
            if (favorite[favorite[i]] != i) {
                neighbors[favorite[i]].add(i);
            }
        }

        int max = 0;
        boolean[] visited = new boolean[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            if (favorite[favorite[i]] == i) {
                max += dfs(i, visited, neighbors);
            }
        }

        for (int i = 0; i < LENGTH; i++) {
            int j = i;
            int count = 0;
            while (!visited[j]) {
                visited[j] = true;
                count++;
                j = favorite[j];
            }
            for (int k = i; k != j; k = favorite[k]) {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int dfs(int idx, boolean[] visited, List<Integer>[] neighbors) {
        visited[idx] = true;
        int answer = 0;
        for (int neighbor : neighbors[idx]) {
            answer = Math.max(answer, dfs(neighbor, visited, neighbors));
        }
        return answer + 1;
    }

}
