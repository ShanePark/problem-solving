package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1850MinimumAdjacentSwapsToReachTheKthSmallestNumber {

    @Test
    public void test() {
        assertThat(getMinSwaps("5489355142", 4)).isEqualTo(2);
        assertThat(getMinSwaps("11112", 4)).isEqualTo(4);
        assertThat(getMinSwaps("00123", 1)).isEqualTo(1);
    }

    public int getMinSwaps(String num, int k) {
        return 0;
    }
}
