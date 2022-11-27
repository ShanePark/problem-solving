package shane.leetcode.contest.weekly.w321;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(pivotInteger(4)).isEqualTo(-1);
        assertThat(pivotInteger(8)).isEqualTo(6);
        assertThat(pivotInteger(1)).isEqualTo(1);
    }

    public int pivotInteger(int n) {
        int left = 1;
        int right = n;
        int smallSum = 0;
        int bigSum = 0;
        while (left < right) {
            if (smallSum > bigSum) {
                bigSum += right--;
            } else {
                smallSum += left++;
            }
        }

        return smallSum == bigSum ? left : -1;

    }

}
