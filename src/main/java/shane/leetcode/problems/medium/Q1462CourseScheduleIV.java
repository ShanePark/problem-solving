package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 23
 * ms
 * Beats
 * 81.76%
 * Analyze
 */
public class Q1462CourseScheduleIV {

    @Test
    public void test() {
        assertThat(checkIfPrerequisite(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}})).containsExactly(false, true);
        assertThat(checkIfPrerequisite(2, new int[][]{}, new int[][]{{1, 0}, {0, 1}})).containsExactly(false, false);
        assertThat(checkIfPrerequisite(3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}})).containsExactly(true, true);
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Boolean[][] required = new Boolean[numCourses][numCourses];
        Map<Integer, List<Integer>> requireMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            requireMap.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            required[prerequisite[0]][prerequisite[1]] = true;
            requireMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];
            answer.add(isRequired(required, requireMap, from, to));
        }
        return answer;
    }

    private Boolean isRequired(Boolean[][] required, Map<Integer, List<Integer>> requireMap, int from, int to) {
        if (required[from][to] != null)
            return required[from][to];
        for (int next : requireMap.get(from)) {
            if (isRequired(required, requireMap, next, to))
                return required[from][to] = true;
        }
        return required[from][to] = false;
    }

}
