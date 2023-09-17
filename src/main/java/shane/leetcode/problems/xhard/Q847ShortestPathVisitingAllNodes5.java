package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q847ShortestPathVisitingAllNodes5 {

    @Test
    void test() {
        assertThat(shortestPathLength(Ps.intArray("[[1,2,3],[0],[0],[0]]"))).isEqualTo(4);
        assertThat(shortestPathLength(Ps.intArray("[[1],[0,2,4],[1,3,4],[2],[1,2]]"))).isEqualTo(4);
    }

    public int shortestPathLength(int[][] graph) {
        final int LENGTH = graph.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < LENGTH; i++) {
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
        }

        int dist[][] = new int[(int) Math.pow(2, LENGTH)][LENGTH];

        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < LENGTH; i++) {
            int mask = 0 | (1 << i);
            q.add(new int[]{i, mask});
            dist[mask][i] = 0;
        }

        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int lead = poll[0];
                int mask = poll[1];

                if (mask == dist.length - 1) {
                    return dist[mask][lead];
                }
                if (!map.containsKey(lead)) {
                    continue;
                }

                for (int child : map.get(lead)) {
                    int newMask = mask | (1 << child);
                    if (dist[newMask][child] != -1) {
                        continue;
                    }
                    dist[newMask][child] = dist[mask][lead] + 1;
                    q.add(new int[]{child, newMask});
                }
            }
        }
    }


}
