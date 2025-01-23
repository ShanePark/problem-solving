package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 19ms
 * Beats5.14%
 */
public class Q1267CountServersThatCommunicate {

    @Test
    public void test() {
        assertThat(countServers(Ps.intArray("[[1,0],[0,1]]"))).isEqualTo(0);
        assertThat(countServers(Ps.intArray("[[1,0],[1,1]]"))).isEqualTo(3);
        assertThat(countServers(Ps.intArray("[[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]"))).isEqualTo(4);
    }

    public int countServers(int[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        Set<String> answer = new HashSet<>();
        for (int i = 0; i < HEIGHT; i++) {
            List<Integer> servers = new ArrayList<>();
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] == 1)
                    servers.add(j);
            }
            if (servers.size() <= 1)
                continue;
            for (Integer s : servers) {
                answer.add(i + " " + s);
            }
        }
        for (int j = 0; j < WIDTH; j++) {
            List<Integer> servers = new ArrayList<>();
            for (int i = 0; i < HEIGHT; i++) {
                if(grid[i][j] ==1)
                    servers.add(i);
            }
            if(servers.size() <=1 )
                continue;

            for (Integer s : servers) {
                answer.add(s + " " + j);
            }
        }
        return answer.size();
    }

}
