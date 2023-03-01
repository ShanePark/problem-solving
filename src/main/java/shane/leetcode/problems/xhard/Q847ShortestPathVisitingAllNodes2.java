package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q847ShortestPathVisitingAllNodes2 {

    @Test
    void test() {
        assertThat(shortestPathLength(Ps.intArray("[[1,2,3],[0],[0],[0]]"))).isEqualTo(4);
        assertThat(shortestPathLength(Ps.intArray("[[1],[0,2,4],[1,3,4],[2],[1,2]]"))).isEqualTo(4);
        assertThat(shortestPathLength(Ps.intArray("[[6,8],[2,9],[1,3,5],[2,6],[5],[2,6,4],[5,3,0,7],[6],[0],[1]]"))).isEqualTo(12);
        assertThat(shortestPathLength(Ps.intArray("[[2,3,5,7],[2,3,7],[0,1],[0,1],[7],[0],[10],[9,10,0,1,4],[9],[7,8],[7,6]]"))).isEqualTo(14);
    }

    @Test
    public void tle() {
        assertThat(shortestPathLength(Ps.intArray("[[2],[3],[3,4,5,6,7,8,9,10,11,0],[2,4,5,6,7,8,9,10,11,1],[2,3,5,6,7,8,9,10,11],[2,3,4,6,7,8,9,10,11],[2,3,4,5,7,8,9,10,11],[2,3,4,5,6,8,9,10,11],[2,3,4,5,6,7,9,10,11],[2,3,4,5,6,7,8,10,11],[2,3,4,5,6,7,8,9,11],[2,3,4,5,6,7,8,9,10]]"))).isEqualTo(11);
    }

    public int shortestPathLength(int[][] graph) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            Integer dfs = dfs(graph, i);
            min = Math.min(min, dfs);

        }
        return min;

    }

    private Integer dfs(int[][] graph, int start) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Status> statusHistory = new HashSet<>();
        Queue<Status> q = new LinkedList();
        set.add(start);
        q.add(new Status(start, 0, set));

        while (!q.isEmpty()) {
            Status poll = q.poll();
            if (poll.set.size() == graph.length) {
                return poll.distance;
            }

            for (int i : graph[poll.location]) {

                boolean notHadBefore = poll.set.add(i);
                Status newStatus = new Status(i, poll.distance + 1, poll.set);
                if (statusHistory.add(newStatus)) {
                    q.add(newStatus);
                }
                if (notHadBefore) {
                    poll.set.remove(i);
                }
            }

        }

        throw new IllegalStateException();
    }

    class Status {
        int location;
        int distance;
        Set<Integer> set;

        public Status(int location, int distance, Set<Integer> set) {
            this.location = location;
            this.distance = distance;
            this.set = new HashSet<>(set);
        }

        @Override
        public String toString() {
            return "Status{" +
                    "location=" + location +
                    ", distance=" + distance +
                    ", set=" + set +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Status)) {
                return false;
            }
            Status status = (Status) o;
            return location == status.location && Objects.equals(set, status.set);
        }

        @Override
        public int hashCode() {
            return Objects.hash(location, set);
        }
    }

}
