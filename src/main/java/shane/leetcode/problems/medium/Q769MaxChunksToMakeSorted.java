package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0ms Beats100.00% 
 */
public class Q769MaxChunksToMakeSorted {

    @Test
    public void test() {
        assertThat(maxChunksToSorted(new int[]{4, 3, 2, 1, 0})).isEqualTo(1);
        assertThat(maxChunksToSorted(new int[]{1, 0, 2, 3, 4})).isEqualTo(4);
    }

    public int maxChunksToSorted(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int chunk = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            int len = i - start + 1;
            if (max == i && max - min == len - 1) {
                chunk++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                start = i + 1;
            }
        }
        return chunk;
    }

}
