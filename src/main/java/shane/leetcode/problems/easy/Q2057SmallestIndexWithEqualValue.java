package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2057SmallestIndexWithEqualValue {

    @Test
    public void test() {
        assertThat(smallestEqual(new int[]{0, 1, 2})).isEqualTo(0);
        assertThat(smallestEqual(new int[]{4, 3, 2, 1})).isEqualTo(2);
        assertThat(smallestEqual(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})).isEqualTo(-1);
    }

    public int smallestEqual(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] == i%10)
                return i;
        }
        return -1;
    }
}
