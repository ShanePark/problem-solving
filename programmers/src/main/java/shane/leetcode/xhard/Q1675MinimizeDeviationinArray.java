package shane.leetcode.xhard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TLE
 */
public class Q1675MinimizeDeviationinArray {

    @Test
    void test() {
        Assertions.assertThat(minimumDeviation(new int[]{1, 2, 3, 4})).isEqualTo(1);
        Assertions.assertThat(minimumDeviation(new int[]{4, 1, 5, 20, 3})).isEqualTo(3);
        Assertions.assertThat(minimumDeviation(new int[]{2, 10, 8})).isEqualTo(3);
        Assertions.assertThat(minimumDeviation(new int[]{3, 5})).isEqualTo(1);
        Assertions.assertThat(minimumDeviation(new int[]{2, 4})).isEqualTo(0);
        Assertions.assertThat(minimumDeviation(new int[]{8, 6, 1, 6})).isEqualTo(1);
        Assertions.assertThat(minimumDeviation(new int[]{10, 4, 3})).isEqualTo(2);
        Assertions.assertThat(minimumDeviation(new int[]{399, 908, 648, 357, 693, 502, 331, 649, 596, 698})).isEqualTo(315);
        Assertions.assertThat(minimumDeviation(new int[]{9, 4, 3, 6, 2})).isEqualTo(7);
    }

    public int minimumDeviation(int[] nums) {

        Set<ArrObj> set = new HashSet<>();
        Arrays.sort(nums);
        return dfs(set, nums, nums[nums.length - 1] - nums[0]);

    }

    int dfs(Set<ArrObj> set, int[] nums, int min) {
        if (nums[0] % 2 == 1) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            temp[0] = temp[0] * 2;
            Arrays.sort(temp);
            if (set.add(new ArrObj(temp))) {
                min = Math.min(min, dfs(set, temp, Math.min(min, temp[nums.length - 1] - temp[0])));
            }
        }

        if (nums[nums.length - 1] % 2 == 0) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            temp[temp.length - 1] = temp[temp.length - 1] / 2;
            Arrays.sort(temp);
            if (set.add(new ArrObj(temp))) {
                min = Math.min(min, dfs(set, temp, Math.min(min, temp[nums.length - 1] - temp[0])));
            }
        }

        if (nums[0] % 2 == 1 && nums[nums.length - 1] % 2 == 0) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            temp[0] = temp[0] * 2;
            temp[temp.length - 1] = temp[temp.length - 1] / 2;
            Arrays.sort(temp);
            if (set.add(new ArrObj(temp))) {
                min = Math.min(min, dfs(set, temp, Math.min(min, temp[nums.length - 1] - temp[0])));
            }
        }

        return min;

    }

    static class ArrObj {
        int[] arr;

        public ArrObj(int[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrObj arrObj = (ArrObj) o;
            return Arrays.equals(arr, arrObj.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

}
