package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 1 〉	통과 (0.16ms, 76.6MB)
 * 테스트 2 〉	통과 (0.24ms, 86.1MB)
 * 테스트 3 〉	통과 (0.16ms, 74.1MB)
 * 테스트 4 〉	통과 (0.80ms, 72.7MB)
 * 테스트 5 〉	통과 (4.11ms, 75.2MB)
 * 테스트 6 〉	통과 (19.34ms, 91.7MB)
 * 테스트 7 〉	통과 (20.60ms, 89.3MB)
 * 테스트 8 〉	통과 (47.83ms, 128MB)
 * 테스트 9 〉	통과 (71.91ms, 101MB)
 * 테스트 10 〉	통과 (97.15ms, 122MB)
 * 테스트 11 〉	통과 (83.54ms, 113MB)
 * 테스트 12 〉	통과 (108.50ms, 156MB)
 * 테스트 13 〉	통과 (119.94ms, 148MB)
 * 테스트 14 〉	통과 (512.43ms, 194MB)
 * 테스트 15 〉	통과 (426.84ms, 365MB)
 * 테스트 16 〉	통과 (1097.32ms, 375MB)
 * 테스트 17 〉	통과 (405.68ms, 388MB)
 * 테스트 18 〉	통과 (403.37ms, 379MB)
 * 테스트 19 〉	통과 (414.89ms, 380MB)
 * 테스트 20 〉	실패 (시간 초과)
 * 테스트 21 〉	통과 (80.47ms, 190MB)
 * 테스트 22 〉	실패 (시간 초과)
 * 테스트 23 〉	통과 (79.25ms, 208MB)
 */
public class 뒤에_있는_큰_수_찾기2 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 3, 3, 5})).containsExactly(3, 5, 5, -1);
        assertThat(solution(new int[]{9, 1, 5, 3, 6, 2})).containsExactly(-1, 5, 6, 6, -1, -1);
    }

    /**
     * 208 ms
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
            Stack<Integer> tmp = new Stack<>();
            int cur = numbers[i];
            while (!stack.isEmpty() && stack.peek() <= cur) {
                Integer pop = stack.pop();
                tmp.add(pop);
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            if (!stack.isEmpty()) {
                stack.addAll(tmp);
            } else {
                stack.clear();
            }
            stack.push(cur);
        }
        return answer;
    }
}
