package shane.leetcode.medium;

import org.assertj.core.api.Assertions;

/**
 * Time Limit Exceeded
 */
public class Q875KokoEatingBananas {
    public static void main(String[] args) {
        Assertions.assertThat(minEatingSpeed(new int[]{3, 6, 7, 11}, 8)).isEqualTo(4);
        Assertions.assertThat(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)).isEqualTo(30);
        Assertions.assertThat(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6)).isEqualTo(23);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        first:for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int temp = 0;
            for (int pile : piles) {
                temp += (pile - 1) / i + 1;
                if (temp > h)
                    continue first;
            }
            return i;
        }
        return -1;
    }

}
