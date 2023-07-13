package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 69.20%
 * Memory 44.7 MB Beats 17.91%
 */
public class Q207CourseSchedule {

    @Test
    public void test() {
        assertThat(canFinish(3, Ps.intArray("[[0,1],[0,2],[1,2]]"))).isTrue();
        assertThat(canFinish(20, Ps.intArray("[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]"))).isFalse();
        assertThat(canFinish(2, Ps.intArray("[[1,0]]"))).isTrue();
        assertThat(canFinish(2, Ps.intArray("[[1,0],[0,1]]"))).isFalse();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] possible = new boolean[numCourses];
        Set<Integer>[] preSets = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            possible[i] = true;
            preSets[i] = new HashSet();
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            possible[course] = false;
            preSets[course].add(pre);
        }

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            boolean canFinish = checkCanFinish(possible, preSets, i, visited);
            if (!canFinish) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCanFinish(boolean[] possible, Set<Integer>[] preSets, int index, Set<Integer> visited) {
        if (possible[index])
            return true;
        Set<Integer> preSet = preSets[index];
        for (Integer pre : preSet) {
            if (possible[pre])
                continue;
            if (!visited.add(pre)) {
                return false;
            }
            if (!checkCanFinish(possible, preSets, pre, visited)) {
                return false;
            }
            visited.remove(pre);
        }
        possible[index] = true;
        return true;
    }

}
