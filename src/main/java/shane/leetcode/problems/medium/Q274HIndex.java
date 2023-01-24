package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 79.24%
 * Memory 40.1 MB Beats 83.76%
 */
public class Q274HIndex {

    @Test
    public void test() {
        assertThat(hIndex(new int[]{11, 15})).isEqualTo(2);
        assertThat(hIndex(new int[]{100})).isEqualTo(1);
        assertThat(hIndex(new int[]{3, 0, 6, 1, 5})).isEqualTo(3);
        assertThat(hIndex(new int[]{1, 3, 1})).isEqualTo(1);
        assertThat(hIndex(new int[]{1, 2, 3, 4})).isEqualTo(2);
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = length - 1; i >= 0; i--) {
            if (citations[i] < length - i)
                return length - i - 1;
        }
        return Math.min(length, citations[0]);
    }

}
