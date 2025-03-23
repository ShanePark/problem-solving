package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1976NumberOfWaysToArriveAtDestination {

    @Test
    public void test() {
        assertThat(countPaths(7, Ps.intArray("[[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]"))).isEqualTo(4);
        assertThat(countPaths(2, Ps.intArray("[[1,0,10]]"))).isEqualTo(1);
    }

    final int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        return dijkstra(graph, n);
    }

    int dijkstra(List<int[]>[] graph, int size) {
        long[] dp = new long[size];
        Arrays.fill(dp, Long.MAX_VALUE);
        long[] ways = new long[size];
        ways[0] = 1;
        dp[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            long distance = poll[0];
            int node = (int) poll[1];
            if (distance > dp[node]) continue;
            for (int[] nei : graph[node]) {
                int v = nei[0];
                long time = nei[1];
                if (dp[v] > distance + time) {
                    dp[v] = distance + time;
                    ways[v] = ways[node];
                    pq.offer(new long[]{dp[v], v});
                } else if (dp[v] == distance + time) {
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            }
        }
        return (int) ways[size - 1];
    }

}
