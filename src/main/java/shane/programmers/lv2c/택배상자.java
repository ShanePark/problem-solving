package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class 택배상자 {

    @Test
    public void test() {
        assertThat(solution(new int[]{5, 4, 3, 2, 1})).isEqualTo(5);
        assertThat(solution(new int[]{4, 3, 1, 2, 5})).isEqualTo(2);
        assertThat(solution(new int[]{1, 2, 5, 4, 3})).isEqualTo(5);
    }

    public int solution(int[] order) {
        int length = order.length;
        int left = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= length; i++) {
            int next = order[left];
            if (next == i) {
                left++;
            } else if (!stack.isEmpty() && next == stack.peek()) {
                stack.pop();
                left++;
                i--;
            } else {
                stack.push(i);
            }
        }
        while (!stack.isEmpty() && stack.pop() == order[left]) {
            left++;
        }
        return left;
    }

}
