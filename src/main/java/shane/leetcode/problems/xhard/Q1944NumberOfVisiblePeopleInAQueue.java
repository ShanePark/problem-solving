package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 118 ms, faster than 79.16% of Java online submissions for Number of Visible People in a Queue.
 * Memory Usage: 57.3 MB, less than 98.31% of Java online submissions for Number of Visible People in a Queue.
 */
public class Q1944NumberOfVisiblePeopleInAQueue {

    @Test
    public void test() {
        assertThat(canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9})).containsExactly(3, 1, 2, 1, 1, 0);
        assertThat(canSeePersonsCount(new int[]{5, 1, 2, 3, 10})).containsExactly(4, 1, 1, 1, 0);
    }

    public int[] canSeePersonsCount(int[] heights) {
        int[] answer = new int[heights.length];
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            for (Integer h : tree) {
                answer[i]++;
                if (height <= h)
                    break;
            }
            while (!tree.isEmpty() && tree.first() <= height) {
                tree.pollFirst();
            }
            tree.add(height);
        }
        return answer;
    }
}
