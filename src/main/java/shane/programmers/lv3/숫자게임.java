package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 숫자게임 {

    @Test
    public void test() {
        assertThat(solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8})).isEqualTo(3);
        assertThat(solution(new int[]{1, 2, 3, 4}, new int[]{2, 3, 4, 5})).isEqualTo(4);
        assertThat(solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1})).isEqualTo(0);
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0, b = 0;
        int cnt = 0;
        while (b < B.length) {
            if (A[a] < B[b]) {
                a++;
                b++;
                cnt++;
            } else {
                b++;
            }
        }
        return cnt;
    }
}
