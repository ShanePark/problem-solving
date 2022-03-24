package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * DFS -> TLE
 */
public class Q991BrokenCalculator {

    @Test
    public void test() {
        assertThat(brokenCalc(2, 3)).isEqualTo(2);
        assertThat(brokenCalc(5, 8)).isEqualTo(2);
        assertThat(brokenCalc(3, 10)).isEqualTo(3);
//        assertThat(brokenCalc(1024, 1)).isEqualTo(1023);
    }

    public int brokenCalc(int startValue, int target) {
        Queue<Try> q = new LinkedList<>();
        q.add(new Try(startValue, 0));

        while (!q.isEmpty()) {
            Try poll = q.poll();
            int value = poll.value;
            int count = poll.count;
            if (value == target) {
                return count;
            }
            q.add(new Try(value * 2, count + 1));
            q.add(new Try(value - 1, count + 1));
        }
        return -1;
    }

    class Try {
        int value;
        int count;

        public Try(int value, int count) {
            this.count = count;
            this.value = value;
        }
    }
}
