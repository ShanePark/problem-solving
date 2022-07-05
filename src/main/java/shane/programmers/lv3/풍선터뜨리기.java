package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 풍선터뜨리기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 6, 2, 7, 3})).isEqualTo(3);
        assertThat(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33})).isEqualTo(6);
        assertThat(solution(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(6);
        assertThat(solution(new int[]{1, 6, 2, 7, 3, -5})).isEqualTo(2);
        assertThat(solution(new int[]{9, -1, -5})).isEqualTo(3);
    }

    public int solution(int[] a) {
        boolean[] possible = new boolean[a.length];
        possible[0] = true;
        possible[a.length - 1] = true;
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                possible[i] = true;
            }
        }
        min = a[a.length - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < min) {
                min = a[i];
                possible[i] = true;
            }
        }
        int cnt = 0;
        for (boolean b : possible) {
            if (b)
                cnt++;
        }
        return cnt;
    }

}
