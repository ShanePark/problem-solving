package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;
import shane.leetcode.util.Leet;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q912SortAnArray4 {

    @Test
    public void test() {
        assertThat(sortArray(new int[]{-50000, 50000})).isEqualTo(new int[]{-50000, 50000});
        assertThat(sortArray(new int[]{5, 2, 3, 1})).isEqualTo(new int[]{1, 2, 3, 5});
        assertThat(sortArray(new int[]{5, 1, 1, 2, 0, 0})).isEqualTo(new int[]{0, 0, 1, 1, 2, 5});
    }

    @Test
    public void test2() throws IOException {
        int[] arr = Arrays.stream(Leet.readFileText(this.getClass(), "Q912SortAnArray.txt").split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(sortArray(arr)).isSorted();
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, tmp, left, mid);
        mergeSort(nums, tmp, mid + 1, right);
        merge(nums, tmp, left, mid, right);
    }

    private void merge(int[] nums, int[] tmp, int left, int mid, int right) {
        System.arraycopy(nums, left, tmp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tmp[i] <= tmp[j]) {
                nums[k++] = tmp[i++];
                continue;
            }
            nums[k++] = tmp[j++];
        }

        while (i <= mid) {
            nums[k++] = tmp[i++];
        }

        while (j <= right) {
            nums[k++] = tmp[j++];
        }
    }

}
