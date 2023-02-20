package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 시소_짝궁 {

    @Test
    public void test() {
        assertThat(solution(new int[]{100, 180, 360, 100, 270})).isEqualTo(4);
    }

    public long solution(int[] weights) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> cnt2 = new HashMap<>();
        Map<Integer, Integer> cnt3 = new HashMap<>();
        Map<Integer, Integer> cnt4 = new HashMap<>();
        long answer = 0;
        for (int weight : weights) {
            answer += cnt2.getOrDefault(weight * 2, 0) +
                    cnt2.getOrDefault(weight * 3, 0) +
                    cnt2.getOrDefault(weight * 4, 0) +
                    cnt3.getOrDefault(weight * 2, 0) +
                    cnt3.getOrDefault(weight * 3, 0) +
                    cnt3.getOrDefault(weight * 4, 0) +
                    cnt4.getOrDefault(weight * 2, 0) +
                    cnt4.getOrDefault(weight * 3, 0) +
                    cnt4.getOrDefault(weight * 4, 0);
            answer -= cnt.getOrDefault(weight, 0) * 2;
            cnt.compute(weight, (k, v) -> v == null ? 1 : v + 1);
            cnt2.compute(weight * 2, (k, v) -> v == null ? 1 : v + 1);
            cnt3.compute(weight * 3, (k, v) -> v == null ? 1 : v + 1);
            cnt4.compute(weight * 4, (k, v) -> v == null ? 1 : v + 1);
        }
        return answer;
    }

}
