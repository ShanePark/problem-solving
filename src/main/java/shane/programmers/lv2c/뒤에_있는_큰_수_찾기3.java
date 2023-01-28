package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class 뒤에_있는_큰_수_찾기3 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 3, 3, 5})).containsExactly(3, 5, 5, -1);
        assertThat(solution(new int[]{9, 1, 5, 3, 6, 2})).containsExactly(-1, 5, 6, 6, -1, -1);
    }

    /**
     * 166 ms
     */
    @Test
    public void tle() {
        int[] arr = IntStream.range(0, 1000000).toArray();
        assertThat(solution(arr));
    }

    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            int cur = numbers[i];
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(cur);
        }
        return answer;
    }
}
