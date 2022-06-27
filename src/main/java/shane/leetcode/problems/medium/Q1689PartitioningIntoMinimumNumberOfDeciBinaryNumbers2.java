package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers2 {

    @Test
    public void test() {
        assertThat(minPartitions("32")).isEqualTo(3);
        assertThat(minPartitions("82734")).isEqualTo(8);
        assertThat(minPartitions("27346209830709182346")).isEqualTo(9);
    }

    public int minPartitions(String n) {
        int max = 0;
        for(int i=0; i<n.length(); i++) {
            max = Math.max(max, n.charAt(i) - '0');
        }
        return max;
    }
}
