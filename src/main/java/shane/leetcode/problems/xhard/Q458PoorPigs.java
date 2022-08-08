package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Poor Pigs.
 * Memory Usage: 40.2 MB, less than 84.00% of Java online submissions for Poor Pigs.
 */
public class Q458PoorPigs {

    @Test
    public void test() {
        assertThat(poorPigs(1, 1, 1)).isEqualTo(0);
        assertThat(poorPigs(1000, 15, 60)).isEqualTo(5);
        assertThat(poorPigs(4, 15, 15)).isEqualTo(2);
        assertThat(poorPigs(4, 15, 30)).isEqualTo(2);
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = -1;
        while (true) {
            if (Math.pow(minutesToTest / minutesToDie + 1, ++pigs) >= buckets)
                return pigs;
        }
    }

}
