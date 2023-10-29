package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my idea
 */
public class Q458PoorPigs2 {

    @Test
    public void test() {
        assertThat(poorPigs(4, 15, 15)).isEqualTo(2);
        assertThat(poorPigs(4, 15, 30)).isEqualTo(2);
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pig = 0;
        int test = minutesToTest / minutesToDie;
        while (Math.pow(test + 1, pig) < buckets) {
            pig++;
        }
        return pig;
    }

}
