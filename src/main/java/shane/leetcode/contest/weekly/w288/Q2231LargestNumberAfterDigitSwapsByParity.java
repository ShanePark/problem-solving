package shane.leetcode.contest.weekly.w288;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2231LargestNumberAfterDigitSwapsByParity {
    @Test
    public void test() {
        assertThat(largestInteger(1234)).isEqualTo(3412);
        assertThat(largestInteger(65875)).isEqualTo(87655);
        assertThat(largestInteger(8)).isEqualTo(8);
        assertThat(largestInteger(27)).isEqualTo(27);
        assertThat(largestInteger(143915027)).isEqualTo(947531201);
    }

    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
        Stack<Boolean> stack = new Stack<>();
        while (num > 0) {
            int n = num % 10;
            boolean isOdd = n % 2 == 1;
            stack.push(isOdd);
            if (isOdd) {
                odd.offer(n);
            } else {
                even.offer(n);
            }
            num /= 10;
        }
        long answer = 0;
        while (!stack.isEmpty()) {
            Boolean isOdd = stack.pop();
            answer += isOdd ? odd.poll() : even.poll();
            answer *= 10;
        }
        return (int) (answer / 10);
    }
}
