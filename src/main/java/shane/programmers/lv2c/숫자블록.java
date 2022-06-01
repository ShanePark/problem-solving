package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점 결과
 * 정확성: 70.0
 * 효율성: 0.0
 * 합계: 70.0 / 100.0
 */
public class 숫자블록 {

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
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0)
                return i;
        }
        return 0;
    }
}
