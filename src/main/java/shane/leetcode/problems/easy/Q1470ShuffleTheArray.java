package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class Q1470ShuffleTheArray {

    public static void main(String[] args) {
        Assertions.assertTrue(Arrays.equals(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3), new int[]{2, 3, 5, 4, 1, 7}));
        Assertions.assertTrue(Arrays.equals(shuffle(new int[]{1,2,3,4,4,3,2,1}, 4), new int[]{1,4,2,3,3,2,4,1}));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] answer = new int[2 * n];
        for (int i = 0; i < n; i++) {
            answer[2 * i] = nums[i];
            answer[2 * i + 1] = nums[n + i];
        }
        return answer;
    }

}
