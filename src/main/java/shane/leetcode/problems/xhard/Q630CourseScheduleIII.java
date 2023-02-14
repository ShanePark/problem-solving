package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q630CourseScheduleIII {

    @Test
    public void test() {
//        assertThat(scheduleCourse(Ps.intArray("[[914,9927],[333,712],[163,5455],[835,5040],[905,8433],[417,8249],[921,9553],[913,7394],[303,7525],[582,8658],[86,957],[40,9152],[600,6941],[466,5775],[718,8485],[34,3903],[380,9996],[316,7755]]"))).isEqualTo(0);
        assertThat(scheduleCourse(Ps.intArray("[[100,200],[200,1300],[1000,1250],[2000,3200]]"))).isEqualTo(3);
        assertThat(scheduleCourse(Ps.intArray("[[1,2]]"))).isEqualTo(1);
        assertThat(scheduleCourse(Ps.intArray("[[3,2],[4,3]]"))).isEqualTo(0);
    }

    public int scheduleCourse(int[][] courses) {
        int max = 0;
        Queue<Status> q = new LinkedList<>();
        int length = courses.length;

        q.offer(new Status(0, 0, new boolean[length]));
        while (!q.isEmpty()) {
            Status status = q.poll();
            boolean hasNext = false;
            for (int i = 0; i < length; i++) {
                if (!status.visited[i] && status.current <= courses[i][1] - courses[i][0]) {
                    boolean[] visited = Arrays.copyOf(status.visited, length);
                    visited[i] = true;
                    q.offer(new Status(status.current + courses[i][0], status.cnt + 1, visited));
                    hasNext = true;
                }
            }
            if (!hasNext) {
                max = Math.max(max, status.cnt);
            }
        }
        return max;
    }

    class Status {
        int current;
        int cnt;
        boolean[] visited;

        public Status(int current, int cnt, boolean[] visited) {
            this.current = current;
            this.cnt = cnt;
            this.visited = visited;
        }
    }

}
