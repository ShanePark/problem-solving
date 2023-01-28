package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 1 〉	통과 (0.15ms, 76.9MB)
 * 테스트 2 〉	통과 (0.18ms, 80.4MB)
 * 테스트 3 〉	통과 (0.23ms, 80.3MB)
 * 테스트 4 〉	통과 (1.02ms, 76.4MB)
 * 테스트 5 〉	통과 (4.28ms, 84MB)
 * 테스트 6 〉	통과 (26.81ms, 96.7MB)
 * 테스트 7 〉	통과 (19.59ms, 78.6MB)
 * 테스트 8 〉	통과 (55.25ms, 108MB)
 * 테스트 9 〉	통과 (80.83ms, 106MB)
 * 테스트 10 〉	통과 (142.86ms, 133MB)
 * 테스트 11 〉	통과 (108.43ms, 113MB)
 * 테스트 12 〉	통과 (218.55ms, 164MB)
 * 테스트 13 〉	통과 (237.56ms, 152MB)
 * 테스트 14 〉	통과 (1430.59ms, 324MB)
 * 테스트 15 〉	통과 (1832.81ms, 450MB)
 * 테스트 16 〉	통과 (5660.32ms, 428MB)
 * 테스트 17 〉	통과 (2415.72ms, 533MB)
 * 테스트 18 〉	통과 (1938.34ms, 509MB)
 * 테스트 19 〉	통과 (1703.13ms, 443MB)
 * 테스트 20 〉	실패 (시간 초과)
 * 테스트 21 〉	실패 (시간 초과)
 * 테스트 22 〉	실패 (시간 초과)
 * 테스트 23 〉	실패 (시간 초과)
 */
public class 뒤에_있는_큰_수_찾기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 3, 3, 5})).containsExactly(3, 5, 5, -1);
        assertThat(solution(new int[]{9, 1, 5, 3, 6, 2})).containsExactly(-1, 5, 6, 6, -1, -1);
    }

    /**
     * So long
     */
//    @Test
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
            stack.addAll(tmp);
            stack.push(cur);
        }
        return answer;
    }
}
