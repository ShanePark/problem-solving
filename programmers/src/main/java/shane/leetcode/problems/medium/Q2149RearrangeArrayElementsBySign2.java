package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2149RearrangeArrayElementsBySign2 {

    @Test
    void test() {
        Assertions.assertThat(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})).containsExactly(3, -2, 1, -5, 2, -4);
    }

    public int[] rearrangeArray(int[] nums) {
        int[] answer = new int[nums.length];
        int plus = 0;
        int minus = 1;
        for (int num : nums) {
            if(num > 0) {
                answer[plus] = num;
                plus += 2;
            }else {
                answer[minus] = num;
                minus += 2;
            }
        }
        return answer;
    }
}
