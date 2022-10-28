package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 콜라문제 {

    @Test
    public void test() {
        assertThat(solution(2, 1, 20)).isEqualTo(19);
        assertThat(solution(3, 1, 20)).isEqualTo(9);
    }

    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int get = (n / a) * b;
            answer += get;
            n = (n % a) + get;
        }
        return answer;
    }
}
