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
 * TLE
 */
public class Q1696JumpGameVI {

    @Test
    public void test() {
        assertThat(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2)).isEqualTo(7);
        assertThat(maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3)).isEqualTo(17);
        assertThat(maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2)).isEqualTo(0);
    }

    /**
     * 3 sec 461 ms
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q1696JumpGameVI.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(maxResult(arr, 90000)).isEqualTo(212070827);
    }

    public int maxResult(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int max = nums[i - 1];
            for (int j = 2; j <= k && (i - j) >= 0; j++) {
                max = Math.max(max, nums[i - j]);
            }
            nums[i] = cur + max;
        }
        return nums[nums.length - 1];
    }
}
