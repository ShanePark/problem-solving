package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 두_원_사이의_정수_쌍 {

    @Test
    public void test() {
        assertThat(solution(2, 3)).isEqualTo(20);
        assertThat(solution(1, 1000000)).isEqualTo(3141592649624L);
    }

    public long solution(int r1, int r2) {
        long answer = 0;
        for (long x = 0; x < r2; x++) {
            long max = (long) Math.floor(Math.sqrt((long) r2 * r2 - x * x));
            long min = (long) Math.ceil(Math.sqrt((long) r1 * r1 - x * x));
            min = Math.max(1, min);

            answer += (max - min) + 1;
        }
        return answer * 4;
    }

}
