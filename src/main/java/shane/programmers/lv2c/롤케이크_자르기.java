package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 롤케이크_자르기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2})).isEqualTo(2);
        assertThat(solution(new int[]{1, 2, 3, 1, 4})).isEqualTo(0);
    }

    public int solution(int[] topping) {
        int cnt = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i : topping) {
            right.merge(i, 1, Integer::sum);
        }

        for (int i = 0; i < topping.length; i++) {
            int top = topping[i];
            left.merge(top, 1, Integer::sum);
            right.merge(top, -1, Integer::sum);
            if (right.get(top) == 0) {
                right.remove(top);
            }
            if (left.size() == right.size()) {
                cnt++;
            }
        }
        return cnt;
    }

}
