package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 1 〉	통과 (0.05ms, 94.5MB)
 * 테스트 2 〉	통과 (0.01ms, 82.5MB)
 * 테스트 3 〉	통과 (8.35ms, 87.8MB)
 * 테스트 4 〉	통과 (11.89ms, 109MB)
 * 테스트 5 〉	통과 (11.38ms, 127MB)
 * 테스트 6 〉	통과 (8.63ms, 94.7MB)
 * 테스트 7 〉	통과 (13.76ms, 92.5MB)
 * 테스트 8 〉	통과 (12.81ms, 108MB)
 * 테스트 9 〉	통과 (8.23ms, 94.2MB)
 * 테스트 10 〉	통과 (0.53ms, 73.7MB)
 * 테스트 11 〉	통과 (5.95ms, 89MB)
 * 테스트 12 〉	통과 (12.23ms, 132MB)
 * 테스트 13 〉	통과 (0.03ms, 77.8MB)
 * 테스트 14 〉	통과 (0.02ms, 76MB)
 * 테스트 15 〉	통과 (0.03ms, 77.3MB)
 * 테스트 16 〉	통과 (0.01ms, 73.9MB)
 * 테스트 17 〉	통과 (0.05ms, 95.4MB)
 * 테스트 18 〉	통과 (0.01ms, 79.9MB)
 */
public class 햄버거_만들기2 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})).isEqualTo(2);
        assertThat(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})).isEqualTo(2);
    }

    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int answer = 0;
        int index = 0;
        for (int n : ingredient) {
            stack[index++] = n;
            if (index >= 4 && stack[index - 4] == 1 && stack[index - 3] == 2 && stack[index - 2] == 3 && stack[index - 1] == 1) {
                index -= 4;
                answer++;
            }
        }
        return answer;
    }

}
