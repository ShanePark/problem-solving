package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 10 ms Beats 84.7%
 * Memory 43.2 MB Beats 55.59%
 */
public class Q926FlipStringToMonotoneIncreasing2 {

    @Test
    public void test() {
        assertThat(minFlipsMonoIncr("11011")).isEqualTo(1);
        assertThat(minFlipsMonoIncr("00110")).isEqualTo(1);
        assertThat(minFlipsMonoIncr("010110")).isEqualTo(2);
        assertThat(minFlipsMonoIncr("00011000")).isEqualTo(2);
    }

    @Test
    public void tle() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("0");
        }
        assertThat(minFlipsMonoIncr(sb.toString())).isEqualTo(0);
    }

    public int minFlipsMonoIncr(String s) {
        final int SIZE = s.length();
        int[] arr = new int[SIZE];
        int cnt = 0;
        for (int i = 0; i < SIZE; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
            arr[i] = cnt;
        }
        int min = Math.min(arr[SIZE - 1], SIZE - arr[SIZE - 1]);
        for (int i = 0; i < SIZE; i++) {
            // 0 from delimiter (not include)
            int zeroCount = SIZE - arr[SIZE - 1] - i - 1 + arr[i];
            min = Math.min(min, arr[i] + zeroCount);
        }
        return min;
    }

}
