package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 48.33% of users with Java
 */
public class Q1700NumberOfStudentsUnableToEatLunch {

    @Test
    public void test() {
        assertThat(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})).isEqualTo(3);
        assertThat(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})).isEqualTo(0);
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            q.offer(students[i]);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int poll = q.poll();
                if (stack.peek() == poll) {
                    stack.pop();
                    continue;
                }
                q.offer(poll);
            }
            if (q.size() == size)
                return size;
        }
        return 0;
    }

}
