package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class 풍선터뜨리기2 {

    @Test
    public void test() {
        assertThat(solution(new int[]{1})).isEqualTo(1);
        assertThat(solution(new int[]{1, 6, 2, 7, 3})).isEqualTo(3);
        assertThat(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33})).isEqualTo(6);
        assertThat(solution(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(6);
        assertThat(solution(new int[]{1, 6, 2, 7, 3, -5})).isEqualTo(2);
        assertThat(solution(new int[]{9, -1, -5})).isEqualTo(3);
    }

    public int solution(int[] a) {
        Set<Integer> possible = new HashSet<>();
        possible.add(a[0]);
        possible.add(a[a.length - 1]);

        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                possible.add(a[i]);
            }
        }

        min = a[a.length - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < min) {
                min = a[i];
                possible.add(a[i]);
            }
        }

        return possible.size();
    }

}
