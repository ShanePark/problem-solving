package shane.leetcode.problems.easy;

public class Q1929ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums) {

        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[nums.length + i] = nums[i];
        }

        return result;
    }

}
