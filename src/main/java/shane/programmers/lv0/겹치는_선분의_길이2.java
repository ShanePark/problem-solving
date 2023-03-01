package shane.programmers.lv0;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Sweeping
 */
public class 겹치는_선분의_길이2 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[0, 5], [3, 9], [1, 10]]"))).isEqualTo(8);
        assertThat(solution(Ps.intArray("[[1, -1], [1, 3], [9, 3]]"))).isEqualTo(0);
        assertThat(solution(Ps.intArray("[[0, 1], [2, 5], [3, 9]]"))).isEqualTo(2);
    }

    public int solution(int[][] lines) {
        for (int[] line : lines) {
            int from = Math.min(line[0], line[1]);
            int to = Math.max(line[0], line[1]);
            line[0] = from;
            line[1] = to;
        }

        Arrays.sort(lines, Comparator.comparingInt(o -> o[0]));

        int cnt = 0;
        int left = -100;
        int[] cur = lines[0];
        for (int i = 1; i < lines.length; i++) {
            int[] next = lines[i];
            while (left < cur[1] && left < next[1]) {
                if (cur[0] <= left && next[0] <= left) {
                    cnt++;
                }
                left++;
            }
            if (cur[1] == left) {
                cur = next;
            }
        }
        return cnt;
    }

}
