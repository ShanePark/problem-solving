package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;

public class Q1929ConcatenationOfArray {
    public static void main(String[] args) {
        STool.printArray(getConcatenation(new int[]{1, 2, 1}));
    }

    public static int[] getConcatenation(int[] nums) {

        int[] result = new int[nums.length * 2];
        for(int i=0; i<nums.length; i++) {
            result[i] = nums[i];
            result[nums.length+i] = nums[i];
        }

        return result;
    }

}
