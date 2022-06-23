package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 줄서는방법3 {

    @Test
    public void test() {
        assertThat(solution(3, 4)).containsExactly(2, 3, 1);
        assertThat(solution(3, 3)).containsExactly(2, 1, 3);
        assertThat(solution(3, 1)).containsExactly(1, 2, 3);
        assertThat(solution(3, 2)).containsExactly(1, 3, 2);
        assertThat(solution(3, 5)).containsExactly(3, 1, 2);
        assertThat(solution(3, 6)).containsExactly(3, 2, 1);
        assertThat(solution(10, 1)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }
        k--;

        for (int i = 0; n > 0; i++, n--) {
            factorial /= n;
            int index = (int) (k / factorial);
            arr[i] = list.get(index);
            list.remove(index);
            k %= factorial;
        }
        return arr;
    }
}
