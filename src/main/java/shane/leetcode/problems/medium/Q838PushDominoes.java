package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 40 ms, faster than 30.93% of Java online submissions for Push Dominoes.
 * Memory Usage: 54.4 MB, less than 52.72% of Java online submissions for Push Dominoes.
 */
public class Q838PushDominoes {

    @Test
    public void test() {
        assertThat(pushDominoes(".L.R...LR..L..")).isEqualTo("LL.RR.LLRRLL..");
        assertThat(pushDominoes("RR.L")).isEqualTo("RR.L");
    }

    public String pushDominoes(String dominoes) {
        final int SIZE = dominoes.length();
        final int MAX = Integer.MAX_VALUE;
        int[] leftDp = new int[SIZE];
        int[] rightDp = new int[SIZE];

        int distance = MAX;
        for (int i = 0; i < SIZE; i++) {
            if (dominoes.charAt(i) == 'R') {
                distance = 0;
            } else if (dominoes.charAt(i) == 'L') {
                distance = MAX;
            } else if (i > 0 && rightDp[i - 1] != MAX) {
                distance++;
            }
            rightDp[i] = distance;
        }

        distance = MAX;
        for (int i = SIZE - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                distance = 0;
            } else if (dominoes.charAt(i) == 'R') {
                distance = MAX;
            } else if (i < SIZE - 1 && leftDp[i + 1] != MAX) {
                distance++;
            }
            leftDp[i] = distance;
        }

        char[] arr = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            if (leftDp[i] == rightDp[i]) {
                arr[i] = '.';
            } else if (leftDp[i] < rightDp[i]) {
                arr[i] = 'L';
            } else {
                arr[i] = 'R';
            }
        }

        return new String(arr);
    }

}
