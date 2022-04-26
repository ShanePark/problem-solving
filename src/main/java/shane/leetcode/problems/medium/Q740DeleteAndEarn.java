package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q740DeleteAndEarn {

    @Test
    void test() {
        Assertions.assertThat(deleteAndEarn(new int[]{3, 4, 2})).isEqualTo(6);
        Assertions.assertThat(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4})).isEqualTo(9);
        Assertions.assertThat(deleteAndEarn(new int[]{1, 2, 3})).isEqualTo(4);
        Assertions.assertThat(deleteAndEarn(new int[]{1, 2, 3, 4})).isEqualTo(6);
    }

    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for (int num : nums) {
            arr[num] += num;
        }
        int take = 0;
        int skip = 0;
        for (int i : arr) {
            int max = Math.max(skip + i, take);
            skip = take;
            take = max;
        }
        return take;
    }

}
