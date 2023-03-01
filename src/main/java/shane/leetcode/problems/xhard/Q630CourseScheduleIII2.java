package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 78 ms, faster than 21.11% of Java online submissions for Course Schedule III.
 * Memory Usage: 74 MB, less than 30.18% of Java online submissions for Course Schedule III.
 */
public class Q630CourseScheduleIII2 {

    @Test
    public void test() {
        assertThat(scheduleCourse(Ps.intArray("[[100,200],[210,1300],[1000,1250],[2000,3200]]"))).isEqualTo(3);
        assertThat(scheduleCourse(Ps.intArray("[[100,200],[200,1300],[1000,1250],[2000,3200]]"))).isEqualTo(3);
        assertThat(scheduleCourse(Ps.intArray("[[2,5],[2,19],[1,8],[1,3]]"))).isEqualTo(4);
        assertThat(scheduleCourse(Ps.intArray("[[1,2],[2,3]]"))).isEqualTo(2);
        assertThat(scheduleCourse(Ps.intArray("[[914,9927],[333,712],[163,5455],[835,5040],[905,8433],[417,8249],[921,9553],[913,7394],[303,7525],[582,8658],[86,957],[40,9152],[600,6941],[466,5775],[718,8485],[34,3903],[380,9996],[316,7755]]")))
                .isEqualTo(18);
        assertThat(scheduleCourse(Ps.intArray("[[1,2]]"))).isEqualTo(1);
        assertThat(scheduleCourse(Ps.intArray("[[3,2],[4,3]]"))).isEqualTo(0);
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int current = 0;
        for (int[] course : courses) {
            current += course[0];
            pq.add(course[0]);
            if (current > course[1]) {
                current -= pq.poll();
            }
        }
        return pq.size();
    }

}
