package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.*;

public class Q847ShortestPathVisitingAllNodes4 {

    @Test
    void test() {
//        Assertions.assertThat(shortestPathLength(STool.convertToIntArray("[[1,2,3],[0],[0],[0]]"))).isEqualTo(4);
        Assertions.assertThat(shortestPathLength(STool.convertToIntArray("[[1],[0,2,4],[1,3,4],[2],[1,2]]"))).isEqualTo(4);
        Assertions.assertThat(shortestPathLength(STool.convertToIntArray("[[6,8],[2,9],[1,3,5],[2,6],[5],[2,6,4],[5,3,0,7],[6],[0],[1]]"))).isEqualTo(12);
        Assertions.assertThat(shortestPathLength(STool.convertToIntArray("[[1],[0,2,4],[1,3],[2],[1,5],[4]]"))).isEqualTo(6);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Assertions.assertThat(shortestPathLength(STool.convertToIntArray("[[1,2,3,4,5,6,7,8,9,10,11],[0,2,3,4,5,6,7,8,9,10,11],[0,1,3,4,5,6,7,8,9,10,11],[0,1,2,4,5,6,7,8,9,10,11],[0,1,2,3,5,6,7,8,9,10,11],[0,1,2,3,4,6,7,8,9,10,11],[0,1,2,3,4,5,7,8,9,10,11],[0,1,2,3,4,5,6,8,9,10,11],[0,1,2,3,4,5,6,7,9,10,11],[0,1,2,3,4,5,6,7,8,10,11],[0,1,2,3,4,5,6,7,8,9,11],[0,1,2,3,4,5,6,7,8,9,10]]"))).isEqualTo(11);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis() + "ms");
    }

    public int shortestPathLength(int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        Set<Status> set = new HashSet<>();
        int target = 0;
        for (int i = 0; i < graph.length; i++) {
            int status = 1 << (i + 1);
            target = target | (status);
            set.add(new Status(status, i));
            q.offer(new int[]{status, i});
        }

        int distance = 0;
        int num = q.size();
        int nextNum = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            num--;
            if (poll[0] == target) {
                return distance;
            }
            for (int i = 0; i < graph[poll[1]].length; i++) {
                int next = graph[poll[1]][i];
                int nextStatus = poll[0] | (1 << (next + 1));
                Status status = new Status(nextStatus, next);
                if (set.contains(status))
                    continue;
                set.add(status);
                q.offer(new int[]{nextStatus, next});
                nextNum++;
            }

            if (num == 0) {
                num = nextNum;
                nextNum = 0;
                distance++;
            }
        }

        return -1;

    }

    class Status {
        int status;
        int node;

        public Status(int status, int node) {
            this.status = status;
            this.node = node;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Status status1 = (Status) o;
            return status == status1.status && node == status1.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(status, node);
        }
    }

}
