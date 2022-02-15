package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

public class Q136SingleNumber {
    public static void main(String[] args) {
        Assertions.assertEquals(singleNumber(new int[]{2, 2, 1}), 1);
        Assertions.assertEquals(singleNumber(new int[]{4, 1, 2, 1, 2}), 4);
        Assertions.assertEquals(singleNumber(new int[]{1}), 1);
    }

    public static int singleNumber(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer = answer ^ num;
        }
        return answer;
    }
}
