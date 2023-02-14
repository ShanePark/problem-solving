package shane.leetcode.problems.easy;

public class Q1TwoSum {
    public static void main(String[] args) {
        twoSum(new int[]{2, 7, 11, 15}, 9);
        twoSum(new int[]{3, 2, 4}, 6);
        twoSum(new int[]{3, 3}, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; i != j && j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
