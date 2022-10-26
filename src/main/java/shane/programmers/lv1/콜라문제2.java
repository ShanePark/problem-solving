package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 콜라문제2 {

    @Test
    public void test() {
        assertThat(solution(2, 1, 20)).isEqualTo(19);
        assertThat(solution(3, 1, 20)).isEqualTo(9);
        assertThat(solution(3, 1, 2)).isEqualTo(0);
    }

    public int solution(int a, int b, int n) {
        return (n - b) / (a - b) * b;
    }

}
