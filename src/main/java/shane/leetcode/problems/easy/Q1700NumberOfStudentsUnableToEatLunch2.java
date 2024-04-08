package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 50.92% of users with Java
 */
public class Q1700NumberOfStudentsUnableToEatLunch2 {

    @Test
    public void test() {
        assertThat(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})).isEqualTo(3);
        assertThat(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})).isEqualTo(0);
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        while (!stack.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int student = queue.poll();
                if (student == stack.peek()) {
                    stack.pop();
                    continue;
                }
                queue.offer(student);
            }
            if (queue.size() == size) {
                break;
            }
        }
        return stack.size();
    }

}
