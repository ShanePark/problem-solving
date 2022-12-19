package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class 귤_고르기 {

    @Test
    public void test() {
        assertThat(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})).isEqualTo(3);
        assertThat(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})).isEqualTo(2);
        assertThat(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})).isEqualTo(1);
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i : tangerine) {
            cntMap.merge(i, 1, Integer::sum);
        }
        List<Integer> counts = cntMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .map(e -> e.getValue())
                .collect(Collectors.toList());
        for (int i = 0; i < counts.size(); i++) {
            Integer cnt = counts.get(i);
            k -= cnt;
            if (k <= 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
