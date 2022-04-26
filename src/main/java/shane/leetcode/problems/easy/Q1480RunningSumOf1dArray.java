package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;

public class Q1480RunningSumOf1dArray {

    public static void main(String[] args) {
        STool.printArray(runningSum(new int[]{1, 2, 3, 4}));
    }

    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

}
