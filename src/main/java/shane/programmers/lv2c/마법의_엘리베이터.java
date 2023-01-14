package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 마법의_엘리베이터 {

    @Test
    public void test() {
        assertThat(solution(95)).isEqualTo(6);
        assertThat(solution(999)).isEqualTo(2);
        assertThat(solution(909)).isEqualTo(4);
        assertThat(solution(16)).isEqualTo(6);
        assertThat(solution(2554)).isEqualTo(16);
        assertThat(solution(100)).isEqualTo(1);
        assertThat(solution(0)).isEqualTo(0);
        assertThat(solution(5)).isEqualTo(5);
    }

    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int last = storey % 10;
            if (last == 5)
                return answer + 5 + Math.min(solution(storey + 5), solution(storey - 5));
            if (last < 5) {
                answer += last;
            } else {
                storey += 10;
                answer += (10 - last);
            }
            storey /= 10;
        }
        return answer;
    }

}
