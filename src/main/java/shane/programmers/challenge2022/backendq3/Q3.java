package shane.programmers.challenge2022.backendq3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점 결과
 * 정확성: 76.7
 * 효율성: 0.0
 * 합계: 76.7 / 100.0
 */
public class Q3 {

    @Test
    public void test() {
        assertThat(solution(1)).isEqualTo(0);
        assertThat(solution(5)).isEqualTo(5);
        assertThat(solution(6)).isEqualTo(7);
        assertThat(solution(11)).isEqualTo(99);
        assertThat(solution(20)).isEqualTo(99);
    }

    Set<String> set;

    public long solution(int k) {
        set = new HashSet<>();
        Map<Integer, Integer> need = new HashMap<>();
        need.put(0, 6);
        need.put(1, 2);
        need.put(2, 5);
        need.put(3, 5);
        need.put(4, 4);
        need.put(5, 5);
        need.put(6, 6);
        need.put(7, 3);
        need.put(8, 7);
        need.put(9, 6);

        dfs(k, "", need);

        return set.size();
    }

    private void dfs(int k, String s, Map<Integer, Integer> need) {
        if (k == 0) {
            set.add(s);
        }
        if (!s.isEmpty() && s.charAt(0) == '0') {
            return;
        }
        for (Map.Entry<Integer, Integer> e : need.entrySet()) {
            Integer number = e.getKey();
            Integer required = e.getValue();
            if (k >= required) {
                dfs(k - required, s + number, need);
            }
        }
    }

}
