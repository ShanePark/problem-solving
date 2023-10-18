package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 29ms Beats 55.56%of users with Java
 * Memory Details 66.13MB Beats 70.67%of users with Java
 */
public class Q2050ParallelCoursesIII {

    @Test
    public void test() {
        assertThat(minimumTime(3, Ps.intArray("[[1,3],[2,3]]"), new int[]{3, 2, 5})).isEqualTo(8);
        assertThat(minimumTime(5, Ps.intArray("[[1,5],[2,5],[3,5],[3,4],[4,5]]"), new int[]{1, 2, 3, 4, 5})).isEqualTo(12);
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        Course[] courses = new Course[n];
        for (int i = 0; i < n; i++) {
            courses[i] = new Course(i, time[i]);
        }
        for (int[] relation : relations) {
            Course prev = courses[relation[0] - 1];
            Course cur = courses[relation[1] - 1];
            cur.required.add(prev);
        }
        int max = 0;
        for (Course course : courses) {
            int minTime = course.getMinTime();
            max = Math.max(max, minTime);
        }
        return max;
    }

    class Course {
        final int index;
        final int time;
        Set<Course> required = new HashSet<>();
        int minTime = 0;

        public Course(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getMinTime() {
            if (minTime > 0)
                return minTime;
            for (Course course : required) {
                minTime = Math.max(minTime, course.getMinTime());
            }

            minTime += time;
            return minTime;
        }
    }

}
