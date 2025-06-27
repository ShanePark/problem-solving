package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 택배상자_꺼내기 {

    @Test
    public void test() {
        assertThat(solution(22, 6, 8)).isEqualTo(3);
        assertThat(solution(13, 3, 6)).isEqualTo(4);
    }

    public int solution(int n, int w, int num) {
        int answer = 0;
        int x = getX(w, (num - 1));
        for (int i = num - 1; i < n; i++) {
            if (x == getX(w, i))
                answer++;
        }
        return answer;
    }

    private int getX(int w, int i) {
        return i / w % 2 == 0 ? i % w : (w - (i % w) - 1);
    }

}
