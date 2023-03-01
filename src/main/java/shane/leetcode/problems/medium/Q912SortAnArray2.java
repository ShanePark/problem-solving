package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Quick sort
 * TLE
 */
public class Q912SortAnArray2 {

    @Test
    public void test() {
        assertThat(sortArray(new int[]{-50000, 50000})).isEqualTo(new int[]{-50000, 50000});
        assertThat(sortArray(new int[]{5, 2, 3, 1})).isEqualTo(new int[]{1, 2, 3, 5});
        assertThat(sortArray(new int[]{5, 1, 1, 2, 0, 0})).isEqualTo(new int[]{0, 0, 1, 1, 2, 5});
    }

    /**
     * 189 ms
     */
    @Test
    public void test2() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q912SortAnArray.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(sortArray(arr)).isSorted();
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pivot = nums[high];
        int sortTarget = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, sortTarget++);
            }
        }
        swap(nums, sortTarget, high);
        quickSort(nums, low, sortTarget - 1);
        quickSort(nums, sortTarget + 1, high);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
