package shane.programmers.lv0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 삼각형의_완성조건_2 {

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 2})).isEqualTo(1);
        assertThat(solution(new int[]{3, 6})).isEqualTo(5);
        assertThat(solution(new int[]{11, 7})).isEqualTo(13);
    }

    public int solution(int[] sides) {
        return 2 * Math.min(sides[0], sides[1]) - 1;
    }
}
