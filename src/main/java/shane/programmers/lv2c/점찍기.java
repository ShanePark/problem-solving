package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 점찍기 {

    @Test
    public void test() {
        assertThat(solution(2, 5)).isEqualTo(8);
        assertThat(solution(2, 4)).isEqualTo(6);
        assertThat(solution(1, 5)).isEqualTo(26);
    }

    public long solution(int k, int d) {
        long answer = 0;
        for (int x = 0; x <= d; x += k) {
            double y = Math.sqrt((long) d * d - (long) x * x);
            int points = ((int) y / k) + 1;
            answer += points;
        }
        return answer;
    }
}
