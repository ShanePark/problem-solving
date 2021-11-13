package shane.leetcode.easy;

import com.tistory.shanepark.STool;

public class Q1920BuildArrayFromPermutation {

    public static void main(String[] args) {
        STool.printArray(buildArray(new int[]{0,2,1,5,3,4}));
    }

    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

}
