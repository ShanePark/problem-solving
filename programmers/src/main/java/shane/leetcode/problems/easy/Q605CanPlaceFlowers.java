package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

public class Q605CanPlaceFlowers {

    public static void main(String[] args) {
        Assertions.assertEquals(true, canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        Assertions.assertEquals(false, canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        Assertions.assertEquals(false, canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        Assertions.assertEquals(true, canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
        Assertions.assertEquals(false, canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 4));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int previous = 0;
        for (int i = 0; i < flowerbed.length && 0 < n; i++) {
            int current = flowerbed[i];
            int next = (i < flowerbed.length - 1) ? flowerbed[i + 1] : 0;
            if (previous + current + next == 0) {
                n--;
                current = 1;
            }
            previous = current;
        }
        return n == 0;
    }

}
