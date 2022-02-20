package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;

@SuppressWarnings("DuplicatedCode")
public class Q875KokoEatingBananas2 {
    public static void main(String[] args) {
        Assertions.assertThat(minEatingSpeed(new int[]{3, 6, 7, 11}, 8)).isEqualTo(4);
        Assertions.assertThat(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)).isEqualTo(30);
        Assertions.assertThat(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6)).isEqualTo(23);
        Assertions.assertThat(minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184
        }, 823855818)).isEqualTo(14);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1_000_000_000;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (checkOK(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public static boolean checkOK(int[] piles, int k, int h) {
        int temp = 0;
        for (int pile : piles) {
            temp += (pile - 1) / k + 1;
            if (temp > h)
                return false;
        }
        return true;
    }

}
