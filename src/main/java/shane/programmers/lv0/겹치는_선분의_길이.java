package shane.programmers.lv0;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 겹치는_선분의_길이 {

    @Test
    public void test() {
        assertThat(solution(STool.convertToIntArray("[[0, 5], [3, 9], [1, 10]]"))).isEqualTo(8);
        assertThat(solution(STool.convertToIntArray("[[1, -1], [1, 3], [9, 3]]"))).isEqualTo(0);
        assertThat(solution(STool.convertToIntArray("[[0, 1], [2, 5], [3, 9]]"))).isEqualTo(2);
    }

    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : lines) {
            int from = Math.min(line[0], line[1]);
            int to = Math.max(line[0], line[1]);
            for (int i = from; i < to; i++) {
                map.merge(i, 1, Integer::sum);
            }
        }

        return (int) map.values().stream().filter(i -> i > 1).count();
    }
}
