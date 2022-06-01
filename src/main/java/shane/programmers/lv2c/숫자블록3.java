package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 숫자블록3 {

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
            if (n % i == 0 && (n / i) <= 10000000) {
                return n / i;
            }
        }
        return n == 1 ? 0 : 1;
    }
}
