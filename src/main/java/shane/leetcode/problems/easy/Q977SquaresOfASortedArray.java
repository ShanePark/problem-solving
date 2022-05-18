package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q977SquaresOfASortedArray {

    @Test
    public void test() {
        assertThat(sortedSquares(new int[]{-4, -1, 0, 3, 10})).containsExactly(0, 1, 9, 16, 100);
        assertThat(sortedSquares(new int[]{-7, -3, 2, 3, 11})).containsExactly(4, 9, 9, 49, 121);
    }

    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num * num);
        }
        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}
