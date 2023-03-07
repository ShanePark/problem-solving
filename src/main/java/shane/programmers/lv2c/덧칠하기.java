package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 덧칠하기 {

    @Test
    public void test() {
        assertThat(solution(8, 4, new int[]{2, 3, 6})).isEqualTo(2);
        assertThat(solution(5, 4, new int[]{1, 3})).isEqualTo(1);
        assertThat(solution(4, 1, new int[]{1, 2, 3, 4})).isEqualTo(4);
    }

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintedUntil = -1;
        for (int i = 0; i < section.length; i++) {
            int toPaint = section[i];
            if (paintedUntil < toPaint) {
                paintedUntil = toPaint + m - 1;
                answer++;
            }
        }
        return answer;
    }

}
