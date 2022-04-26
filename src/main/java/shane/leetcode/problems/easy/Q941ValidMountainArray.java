package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q941ValidMountainArray {

    @Test
    void test() {
        Assertions.assertThat(validMountainArray(new int[]{2, 1})).isFalse();
        Assertions.assertThat(validMountainArray(new int[]{3, 5, 5})).isFalse();
        Assertions.assertThat(validMountainArray(new int[]{0, 3, 2, 1})).isTrue();
        Assertions.assertThat(validMountainArray(new int[]{0, 1, 2, 3, 2, 3, 1})).isFalse();
        Assertions.assertThat(validMountainArray(new int[]{0, 5, 2, 2, 1})).isFalse();
        Assertions.assertThat(validMountainArray(new int[]{0, 5, 8, 9, 1})).isTrue();
        Assertions.assertThat(validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})).isFalse();
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        if (arr[0] >= arr[1])
            return false;
        boolean increase = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (increase) {
                if (arr[i] == arr[i + 1]) {
                    return false;
                } else if (arr[i] > arr[i + 1])
                    increase = false;
            } else {
                if (arr[i] <= arr[i + 1])
                    return false;
            }

        }
        return !increase;
    }

}
