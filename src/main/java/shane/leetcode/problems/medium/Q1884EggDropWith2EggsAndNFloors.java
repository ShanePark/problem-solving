package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Egg Drop With 2 Eggs and N Floors.
 * Memory Usage: 41.8 MB, less than 29.49% of Java online submissions for Egg Drop With 2 Eggs and N Floors.
 */
public class Q1884EggDropWith2EggsAndNFloors {

    @Test
    public void test() {
        assertThat(twoEggDrop(100)).isEqualTo(14);
        assertThat(twoEggDrop(1)).isEqualTo(1);
        assertThat(twoEggDrop(2)).isEqualTo(2);
        assertThat(twoEggDrop(11)).isEqualTo(5);
    }

    public int twoEggDrop(int n) {
        int cnt = 0;
        while (n > 0) {
            n -= ++cnt;
        }
        return cnt;
    }
}
