package shane.programmers.lv0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 연속된_수의_합 {

    @Test
    public void test() {
        assertThat(solution(3, 12)).containsExactly(3, 4, 5);
        assertThat(solution(5, 5)).containsExactly(-1, 0, 1, 2, 3);
    }

    public int[] solution(int num, int total) {
        for (int i = 1; i < num; i++) {
            total -= i;
        }
        int first = total / num;
        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = first + i;
        }
        return answer;
    }

}
