package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100%
 * Memory 44.6 MB Beats 11.97%
 */
public class Q605CanPlaceFlowers2 {

    @Test
    public void test() {
        assertThat(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2)).isFalse();
        assertThat(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)).isTrue();
        assertThat(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)).isFalse();
        assertThat(canPlaceFlowers(new int[]{1, 0}, 1)).isFalse();
        assertThat(canPlaceFlowers(new int[]{0, 0}, 1)).isTrue();
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && 0 < n; i += 2) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                i++;
                continue;
            }
            n--;
        }
        return n == 0;
    }

}
