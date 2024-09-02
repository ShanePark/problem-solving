package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2msBeats72.59%
 */
public class Q1894FindTheStudentThatWillReplaceTheChalk {

    @Test
    public void test() {
        assertThat(chalkReplacer(new int[]{5, 1, 5}, 22)).isEqualTo(0);
        assertThat(chalkReplacer(new int[]{3, 4, 1, 2}, 25)).isEqualTo(1);
        int[] arr = new int[100000];
        Arrays.fill(arr, 10000);
        assertThat(chalkReplacer(arr, 1000000000)).isEqualTo(0);
    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int j : chalk) {
            sum += j;
        }
        if (sum <= k) {
            k %= (int) sum;
        }
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return -1;
    }

}
