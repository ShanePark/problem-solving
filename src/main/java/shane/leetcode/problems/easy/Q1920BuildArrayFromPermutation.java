package shane.leetcode.problems.easy;

import java.util.Arrays;

public class Q1920BuildArrayFromPermutation {

    public static void main(String[] args) {
        int[] arr = buildArray(new int[]{0, 2, 1, 5, 3, 4});
        System.err.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

}
