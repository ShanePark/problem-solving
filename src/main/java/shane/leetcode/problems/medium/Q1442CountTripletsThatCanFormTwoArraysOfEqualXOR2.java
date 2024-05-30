package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100.00% of users with Java
 */
public class Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR2 {

    @Test
    public void test() {
        assertThat(countTriplets(new int[]{2, 3, 1, 6, 7})).isEqualTo(4);
        assertThat(countTriplets(new int[]{1, 1, 1, 1, 1})).isEqualTo(10);
    }

    public int countTriplets(int[] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    answer += j - i;
                }
            }
        }
        return answer;
    }

}
