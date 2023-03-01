package shane.programmers.lv0;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 평행 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[1, 4], [9, 2], [3, 8], [10, 4]]"))).isEqualTo(1);
        assertThat(solution(Ps.intArray("[[3, 5], [4, 1], [2, 4], [5, 10]]"))).isEqualTo(0);
    }

    public int solution(int[][] dots) {
        boolean b1 = (dots[0][0] - dots[1][0]) * (dots[2][1] - dots[3][1]) == (dots[0][1] - dots[1][1]) * (dots[2][0] - dots[3][0]);
        boolean b2 = (dots[0][0] - dots[2][0]) * (dots[1][1] - dots[3][1]) == (dots[0][1] - dots[2][1]) * (dots[1][0] - dots[3][0]);
        boolean b3 = (dots[0][0] - dots[3][0]) * (dots[2][1] - dots[1][1]) == (dots[0][1] - dots[3][1]) * (dots[2][0] - dots[1][0]);

        return (b1 || b2 || b3) ? 1 : 0;
    }
}
