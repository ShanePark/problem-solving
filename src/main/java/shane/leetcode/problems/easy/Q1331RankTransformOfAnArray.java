package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime37msBeats29.59%
 */
public class Q1331RankTransformOfAnArray {

    @Test
    public void test() {
        assertThat(arrayRankTransform(new int[]{40, 10, 20, 30})).isEqualTo(new int[]{4, 1, 2, 3});
        assertThat(arrayRankTransform(new int[]{100, 100, 100})).isEqualTo(new int[]{1, 1, 1});
        assertThat(arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})).isEqualTo(new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3});
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return arr;
        List<Num> nums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nums.add(new Num(i, arr[i]));
        }
        Collections.sort(nums);

        Num best = nums.get(0);
        best.rank = 1;

        Num before = best;
        arr[best.index] = 1;
        for (int i = 1; i < nums.size(); i++) {
            Num num = nums.get(i);
            num.rank = before.rank;
            if (num.value != before.value) {
                num.rank = before.rank + 1;
            }
            arr[num.index] = num.rank;
            before = num;
        }
        return arr;
    }

    static class Num implements Comparable<Num> {
        final int index;
        final int value;
        int rank = -1;

        Num(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Num o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

}
