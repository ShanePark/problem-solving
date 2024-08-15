package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2msBeats95.27%
 */
public class Q860LemonadeChange {

    @Test
    public void test() {
        assertThat(lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5})).isTrue();
        assertThat(lemonadeChange(new int[]{5, 5, 5, 10, 20})).isTrue();
        assertThat(lemonadeChange(new int[]{5, 5, 10, 10, 20})).isFalse();
    }

    public boolean lemonadeChange(int[] bills) {
        int bill5 = 0;
        int bill10 = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    bill5++;
                    break;
                case 10:
                    bill5--;
                    if (bill5 < 0)
                        return false;
                    bill10++;
                    break;
                case 20:
                    if (bill10 > 0) {
                        bill5--;
                        bill10--;
                        if (bill5 < 0)
                            return false;
                        break;
                    }
                    bill5 -= 3;
                    if (bill5 < 0)
                        return false;
                    break;
            }
        }
        return true;
    }

}
