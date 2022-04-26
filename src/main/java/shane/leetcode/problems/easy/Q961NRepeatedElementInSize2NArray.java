package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q961NRepeatedElementInSize2NArray {

    @Test
    public void test() {
        assertThat(repeatedNTimes(new int[]{1, 2, 3, 3})).isEqualTo(3);
        assertThat(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4})).isEqualTo(5);
        assertThat(repeatedNTimes(new int[]{1, 2, 5, 6, 7, 8, 3, 3, 3, 3, 3, 3})).isEqualTo(3);
        assertThat(repeatedNTimes(new int[]{1, 2, 5, 6, 7, 8, 3, 3, 3, 3, 3, 3})).isEqualTo(3);
        assertThat(repeatedNTimes(new int[]{9, 5, 6, 9})).isEqualTo(9);
    }

//    public int repeatedNTimes(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.merge(num, 1, Integer::sum) == nums.length / 2)
//                return num;
//        }
//        return -1;
//    }

    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++)
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2])
                return nums[i];
        return nums[nums.length - 1];
    }

}
