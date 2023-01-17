package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q926FlipStringToMonotoneIncreasing {

    @Test
    public void test() {
        assertThat(minFlipsMonoIncr("00110")).isEqualTo(1);
        assertThat(minFlipsMonoIncr("010110")).isEqualTo(2);
        assertThat(minFlipsMonoIncr("00011000")).isEqualTo(2);
    }

    /**
     * 3 sec 485 ms
     */
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
        Arrays.fill(arr, 1);
        int min = countDiff(s, arr);

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 0;
            int cnt = countDiff(s, arr);
            min = Math.min(cnt, min);
        }
        return min;
    }

    private static int countDiff(String s, int[] arr) {
        int cnt = 0;
        for (int j = 0; j < arr.length; j++) {
            if (s.charAt(j) - '0' != arr[j])
                cnt++;
        }
        return cnt;
    }
}
