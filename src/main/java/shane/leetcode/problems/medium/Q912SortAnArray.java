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
 * Runtime 5 ms Beats 99.16% Memory 51.5 MB Beats 94.39%
 */
public class Q912SortAnArray {

    @Test
    public void test() {
        assertThat(sortArray(new int[]{-50000, 50000})).isEqualTo(new int[]{-50000, 50000});
        assertThat(sortArray(new int[]{5, 2, 3, 1})).isEqualTo(new int[]{1, 2, 3, 5});
        assertThat(sortArray(new int[]{5, 1, 1, 2, 0, 0})).isEqualTo(new int[]{0, 0, 1, 1, 2, 5});
    }

    @Test
    public void test2() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q912SortAnArray.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(sortArray(arr)).isSorted();
    }

    public int[] sortArray(int[] nums) {
        int[] bucket = new int[100_001];
        for (int num : nums) {
            bucket[num + 5 * 10_000]++;
        }
        int i = 0;
        for (int j = 0; j <= 100_000; j++) {
            for (int k = 0; k < bucket[j]; k++) {
                nums[i++] = j - 5 * 10_000;
            }
        }
        return nums;
    }

}
