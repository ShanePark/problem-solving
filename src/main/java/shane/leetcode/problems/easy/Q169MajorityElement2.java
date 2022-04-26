package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q169MajorityElement2 {

    @Test
    void test() {
        Assertions.assertThat(majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
        Assertions.assertThat(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
    }

    public int majorityElement(int[] nums) {
        int majorNum = nums[0];
        int cnt = 0;
        for (int num : nums) {
            if (num == majorNum) {
                cnt++;
            } else if (cnt == 0) {
                majorNum = num;
                cnt = 1;
            } else {
                cnt--;
            }
        }
        return majorNum;
    }
}
