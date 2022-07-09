package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 52 ms, faster than 24.21% of Java online submissions for Minimum Number of Operations to Reinitialize a Permutation.
 * Memory Usage: 53.4 MB, less than 28.42% of Java online submissions for Minimum Number of Operations to Reinitialize a Permutation.
 */
public class Q1806MinimumNumberOfOperationsToReinitializeAPermutation {

    @Test
    public void test() {
        assertThat(reinitializePermutation(2)).isEqualTo(1);
        assertThat(reinitializePermutation(4)).isEqualTo(2);
        assertThat(reinitializePermutation(6)).isEqualTo(4);
        assertThat(reinitializePermutation(8)).isEqualTo(3);
    }

    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int cnt = 1;
        int[] processed = process(arr);
        while (!Arrays.equals(arr, processed)) {
            System.out.println(cnt);
            System.out.println("Arrays.toString(processed) = " + Arrays.toString(processed));
            processed = process(processed);
            cnt++;
        }
        return cnt;
    }

    private int[] process(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                next[i] = arr[i / 2];
            } else {
                next[i] = arr[n / 2 + (i - 1) / 2];
            }
        }
        return next;
    }
}
