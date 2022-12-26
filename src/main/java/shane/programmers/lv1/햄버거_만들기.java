package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 1 〉	통과 (0.19ms, 73.9MB)
 * 테스트 2 〉	통과 (0.13ms, 86.2MB)
 * 테스트 3 〉	통과 (69.94ms, 109MB)
 * 테스트 4 〉	통과 (73.13ms, 131MB)
 * 테스트 5 〉	통과 (80.79ms, 144MB)
 * 테스트 6 〉	통과 (79.86ms, 127MB)
 * 테스트 7 〉	통과 (74.43ms, 127MB)
 * 테스트 8 〉	통과 (77.97ms, 106MB)
 * 테스트 9 〉	통과 (47.45ms, 122MB)
 * 테스트 10 〉	통과 (4.69ms, 84.9MB)
 * 테스트 11 〉	통과 (36.46ms, 99.9MB)
 * 테스트 12 〉	통과 (82.92ms, 143MB)
 * 테스트 13 〉	통과 (0.09ms, 78.7MB)
 * 테스트 14 〉	통과 (0.17ms, 80.1MB)
 * 테스트 15 〉	통과 (0.12ms, 75.5MB)
 * 테스트 16 〉	통과 (0.10ms, 73.4MB)
 * 테스트 17 〉	통과 (0.14ms, 70.4MB)
 * 테스트 18 〉	통과 (0.12ms, 73.4MB)
 */
public class 햄버거_만들기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})).isEqualTo(2);
        assertThat(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})).isEqualTo(2);
    }

    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int n : ingredient) {
            stack.push(n);
            if (n == 1) {
                answer += tryPop(stack);
            }
        }
        return answer;
    }

    private int tryPop(Stack<Integer> stack) {
        int result = 0;
        if (stack.size() < 4) {
            return result;
        }
        int p4 = stack.pop();
        int p3 = stack.pop();
        int p2 = stack.pop();
        int p1 = stack.pop();
        if (p1 == 1 && p2 == 2 && p3 == 3 && p4 == 1) {
            result += 1 + tryPop(stack);
        } else {
            stack.push(p1);
            stack.push(p2);
            stack.push(p3);
            stack.push(p4);
        }
        return result;
    }

}
