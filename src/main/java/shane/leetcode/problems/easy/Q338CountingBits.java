package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q338CountingBits {

    @Test
    void test() {
        Assertions.assertThat(countBits(2)).containsExactly(0, 1, 1);
        Assertions.assertThat(countBits(5)).containsExactly(0, 1, 1, 2, 1, 2);
    }

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }
}
