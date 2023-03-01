package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q743NetworkDelayTime {

    @Test
    public void test() {
        assertThat(networkDelayTime(Ps.intArray("[[1,2,1],[2,3,2],[1,3,4]]"), 3, 1)).isEqualTo(3);
        assertThat(networkDelayTime(Ps.intArray("[[2,1,1],[2,3,1],[3,4,1]]"), 4, 2)).isEqualTo(2);
        assertThat(networkDelayTime(Ps.intArray("[[1,2,1]]"), 2, 1)).isEqualTo(1);
        assertThat(networkDelayTime(Ps.intArray("[[1,2,1]]"), 2, 2)).isEqualTo(-1);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            List<Edge> list = map.get(time[0]);
            list.add(new Edge(time[1], time[2]));
        }

        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i != k) {
                arr[i] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            List<Edge> edges = map.get(poll);
            if (edges == null) {
                continue;
            }
            for (Edge edge : edges) {
                int distance = arr[poll] + edge.time;
                if (arr[edge.to] == -1 || arr[edge.to] > distance) {
                    q.offer(edge.to);
                    arr[edge.to] = distance;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (arr[i] == -1) {
                return -1;
            }
        }

        return max;
    }

    class Edge {
        int to;
        int time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", time=" + time +
                    '}';
        }
    }

}
