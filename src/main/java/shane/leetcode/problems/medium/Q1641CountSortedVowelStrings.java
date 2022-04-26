package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1641CountSortedVowelStrings {

    @Test
    public void test() {
        assertThat(countVowelStrings(1)).isEqualTo(5);
        assertThat(countVowelStrings(2)).isEqualTo(15);
        assertThat(countVowelStrings(3)).isEqualTo(35);
        assertThat(countVowelStrings(33)).isEqualTo(66045);
    }


    public int countVowelStrings(int n) {
        int[] arr = {1, 1, 1, 1, 1};

        for (int i = 0; i < n - 1; i++) {
            arr[0] += arr[1] + arr[2] + arr[3] + arr[4];
            arr[1] += arr[2] + arr[3] + arr[4];
            arr[2] += arr[3] + arr[4];
            arr[3] += +arr[4];
        }

        return arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
    }

}
