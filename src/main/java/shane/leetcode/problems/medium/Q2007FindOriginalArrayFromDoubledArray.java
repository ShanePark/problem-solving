package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 205 ms, faster than 49.70% of Java online submissions for Find Original Array From Doubled Array.
 * Memory Usage: 260.5 MB, less than 5.09% of Java online submissions for Find Original Array From Doubled Array.
 */
public class Q2007FindOriginalArrayFromDoubledArray {

    @Test
    public void test() {
        assertThat(findOriginalArray(new int[]{0, 0, 0, 0})).containsExactlyInAnyOrder(0, 0);
        assertThat(findOriginalArray(new int[]{2, 2, 1, 1})).containsExactlyInAnyOrder(1, 1);
        assertThat(findOriginalArray(new int[]{4, 2, 8, 1})).containsExactlyInAnyOrder(1, 4);
        assertThat(findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})).containsExactlyInAnyOrder(1, 3, 4);
        assertThat(findOriginalArray(new int[]{6, 3, 0, 1})).containsExactlyInAnyOrder();
        assertThat(findOriginalArray(new int[]{1})).containsExactlyInAnyOrder();
    }

    public int[] findOriginalArray(int[] changed) {
        final int LENGTH = changed.length;
        final int[] EMPTY = {};
        if (LENGTH % 2 == 1) {
            return EMPTY;
        }

        int[] arr = new int[1000001];
        for (int i : changed) {
            arr[i]++;
        }
        if (arr[0] % 2 == 1)
            return EMPTY;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            int cnt = arr[i];
            arr[i * 2] -= cnt;
            if (arr[i * 2] < 0)
                return EMPTY;
            for (int j = 0; j < cnt; j++) {
                list.add(i);
            }
        }
        for (int i = 50001; i <= 100000; i++) {
            if (arr[i] > 0) {
                return EMPTY;
            }
        }
        for (int i = 0; i < arr[0] / 2; i++) {
            list.add(0);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
