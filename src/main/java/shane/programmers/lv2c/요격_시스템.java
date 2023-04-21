package shane.programmers.lv2c;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class 요격_시스템 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,5]]"))).isEqualTo(2);
        assertThat(solution(Ps.intArray("[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]"))).isEqualTo(3);
    }

    public int solution(int[][] targets) {
        List<Missile> list = Arrays.stream(targets)
                .map(Missile::new)
                .sorted()
                .collect(Collectors.toList());

        int cnt = 0;
        int end = 0;
        for (Missile missile : list) {
            if (end <= missile.start) {
                cnt++;
                end = missile.end;
            }
        }
        return cnt;
    }

    class Missile implements Comparable {
        int start;
        int end;

        public Missile(int[] target) {
            this.start = target[0];
            this.end = target[1];
        }

        @Override
        public int compareTo(Object o) {
            Missile m = (Missile) o;
            if (this.end == m.end)
                return Integer.compare(this.start, m.start);
            return Integer.compare(this.end, m.end);
        }

        @Override
        public String toString() {
            return "Missile{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}
