package shane.leetcode.contest.weekly.w304;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1_2 {

    @Test
    public void test() {
        assertThat(minimumOperations(new int[]{10})).isEqualTo(1);
        assertThat(minimumOperations(new int[]{1, 5, 0, 3, 5})).isEqualTo(3);
        assertThat(minimumOperations(new int[]{0})).isEqualTo(0);
    }


    public int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums).distinct().filter(n -> n > 0).count();
    }


}
