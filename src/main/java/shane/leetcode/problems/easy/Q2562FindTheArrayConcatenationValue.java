package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 97.26%
 * Memory 42.3 MB Beats 25.96%
 */
public class Q2562FindTheArrayConcatenationValue {

    @Test
    void test() {
        assertThat(findTheArrayConcVal(new int[]{7, 52, 2, 4})).isEqualTo(596);
        assertThat(findTheArrayConcVal(new int[]{5, 14, 13, 8, 12})).isEqualTo(673);
    }

    public long findTheArrayConcVal(int[] nums) {
        long answer = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            long n1 = nums[left++];
            long n2 = nums[right--];
            int lev = (int) Math.pow(10, (int) Math.log10(n2) + 1);
            answer += n1 * lev + n2;
        }
        if (left == right)
            answer += nums[left];
        return answer;
    }

}
