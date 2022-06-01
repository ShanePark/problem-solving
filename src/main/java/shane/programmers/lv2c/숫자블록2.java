package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.06ms, 78.2MB)
 * 테스트 2 〉	통과 (0.07ms, 74.1MB)
 * 테스트 3 〉	통과 (0.09ms, 77.6MB)
 * 테스트 4 〉	통과 (0.12ms, 73.7MB)
 * 테스트 5 〉	통과 (0.06ms, 72.8MB)
 * 테스트 6 〉	통과 (0.03ms, 75MB)
 * 테스트 7 〉	통과 (0.15ms, 77.9MB)
 * 테스트 8 〉	통과 (0.04ms, 77.9MB)
 * 테스트 9 〉	통과 (0.04ms, 73.7MB)
 * 테스트 10 〉	통과 (0.14ms, 76.8MB)
 * 테스트 11 〉	통과 (0.07ms, 76.4MB)
 * 테스트 12 〉	통과 (0.11ms, 74.9MB)
 * 테스트 13 〉	통과 (0.04ms, 76.7MB)
 * 테스트 14 〉	통과 (0.03ms, 83.4MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (10.58ms, 52.8MB)
 * 테스트 2 〉	실패 (36.35ms, 53.3MB)
 * 테스트 3 〉	실패 (33.68ms, 52.9MB)
 * 테스트 4 〉	실패 (32.36ms, 53.7MB)
 * 테스트 5 〉	실패 (11.79ms, 52.4MB)
 * 테스트 6 〉	실패 (8.91ms, 52.4MB)
 * 채점 결과
 * 정확성: 70.0
 * 효율성: 0.0
 * 합계: 70.0 / 100.0
 */
public class 숫자블록2 {

    @Test
    public void test() {
        assertThat(solution(1, 10)).containsExactly(0, 1, 1, 2, 1, 3, 1, 4, 3, 5);
    }

    @Test
    public void test2() {
        assertThat(solution(10, 15)).containsExactly(5, 1, 6, 1, 7, 5);
    }

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        for (int i = (int) begin; i <= end; i++) {
            answer[i - (int) begin] = getNumber(i);
        }
        return answer;
    }

    private int getNumber(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return n / i;
            }
        }
        return n == 1 ? 0 : 1;
    }
}
