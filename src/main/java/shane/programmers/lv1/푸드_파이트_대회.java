package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 푸드_파이트_대회 {

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 3, 4, 6})).isEqualTo("1223330333221");
        assertThat(solution(new int[]{1, 7, 1, 2})).isEqualTo("111303111");
    }

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }
        return sb.toString() + "0" + sb.reverse();
    }
}
