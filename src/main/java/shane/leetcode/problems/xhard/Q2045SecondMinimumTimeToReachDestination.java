package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime330msBeats5.33%
 */
public class Q2045SecondMinimumTimeToReachDestination {

    @Test
    public void test() {
        assertThat(secondMinimum(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}}, 3, 5)).isEqualTo(13);
        assertThat(secondMinimum(2, new int[][]{{1, 2}}, 3, 2)).isEqualTo(11);
    }

    @Test
    public void test2() throws IOException {
        String path = getClass().getPackage().getName().replaceAll("\\.", separator)
                + separator
                + getClass().getSimpleName();
        String file = getClass().getClassLoader().getResource(path).getFile();
        String str = new BufferedReader(new FileReader(file)).readLine();
        assertThat(secondMinimum(520, Ps.intArray(str), 946, 183)).isEqualTo(3142);
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // {current node, current time}

        int[] firstTime = new int[n + 1];
        int[] secondTime = new int[n + 1];
        Arrays.fill(firstTime, Integer.MAX_VALUE);
        Arrays.fill(secondTime, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            int currentTime = poll[1];

            if (firstTime[node] == currentTime || secondTime[node] <= currentTime) {
                continue;
            }

            secondTime[node] = currentTime;
            if (secondTime[node] < firstTime[node]) {
                int temp = firstTime[node];
                firstTime[node] = secondTime[node];
                secondTime[node] = temp;
            }

            // Handle traffic signal
            if ((currentTime / change) % 2 == 1) {
                currentTime = (currentTime / change + 1) * change;
            }

            for (int next : graph.get(node)) {
                pq.offer(new int[]{next, currentTime + time});
            }
        }
        return secondTime[n];
    }

}
