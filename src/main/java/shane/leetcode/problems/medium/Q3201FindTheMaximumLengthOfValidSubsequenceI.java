package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
4ms
Beats86.07%

 */
public class Q3201FindTheMaximumLengthOfValidSubsequenceI {

    @Test
    public void test() {
        assertThat(maximumLength(new int[]{1, 2, 3, 4})).isEqualTo(4);
        assertThat(maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2})).isEqualTo(6);
        assertThat(maximumLength(new int[]{1, 3})).isEqualTo(2);
        assertThat(maximumLength(new int[]{1, 1, 1, 1, 1})).isEqualTo(5);
    }

    public int maximumLength(int[] nums) {
        int oddCnt = 0;
        int oddMaxlength = 0;
        int evenMaxlength = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                oddCnt++;
                evenMaxlength = Math.max(oddMaxlength + 1, evenMaxlength);
                continue;
            }
            oddMaxlength = Math.max(evenMaxlength + 1, oddMaxlength);
        }
        int max = Math.max(oddCnt, nums.length - oddCnt);
        max = Math.max(max, oddMaxlength);
        max = Math.max(max, evenMaxlength);
        return max;
    }

}
