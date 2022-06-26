package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1860IncrementalMemoryLeak {

    @Test
    public void test() {
        assertThat(memLeak(2, 2)).containsExactly(3, 1, 0);
        assertThat(memLeak(8, 11)).containsExactly(6, 0, 4);
    }

    public int[] memLeak(int memory1, int memory2) {
        int t = 1;
        while (true) {
            if (memory1 >= memory2) {
                if (memory1 < t)
                    break;
                memory1 -= t;
            } else {
                if (memory2 < t)
                    break;
                memory2 -= t;
            }
            t++;
        }
        return new int[]{t, memory1, memory2};
    }

}
