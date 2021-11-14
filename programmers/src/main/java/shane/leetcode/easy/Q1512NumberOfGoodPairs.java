package shane.leetcode.easy;

import org.junit.Assert;

public class Q1512NumberOfGoodPairs {

    public static void main(String[] args) {
        Assert.assertEquals(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}), 4);
        Assert.assertEquals(numIdenticalPairs(new int[]{1, 1, 1, 1}), 6);
        Assert.assertEquals(numIdenticalPairs(new int[]{1, 2, 3}), 0);
    }

    public static int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    result++;
            }
        }
        return result;
    }
}
