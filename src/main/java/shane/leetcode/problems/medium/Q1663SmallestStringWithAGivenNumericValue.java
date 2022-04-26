package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1663SmallestStringWithAGivenNumericValue {

    @Test
    public void test() {
        assertThat(getSmallestString(3, 27)).isEqualTo("aay");
        assertThat(getSmallestString(5, 73)).isEqualTo("aaszz");
    }

    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        k -= n;

        int index = n - 1;
        while (k > 0) {
            int process = Math.min(k, 'z' - 'a');
            arr[index] += process;
            index--;
            k -= process;
        }

        return String.valueOf(arr);
    }
}
