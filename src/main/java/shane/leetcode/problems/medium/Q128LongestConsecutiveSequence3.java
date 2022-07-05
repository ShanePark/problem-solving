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
 * O(nlogn) but accepted
 */
@SuppressWarnings("ALL")
public class Q128LongestConsecutiveSequence3 {

    @Test
    public void test() {
        assertThat(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6})).isEqualTo(7);
        assertThat(longestConsecutive(new int[]{0})).isEqualTo(1);
        assertThat(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})).isEqualTo(9);
        assertThat(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})).isEqualTo(4);
        assertThat(longestConsecutive(new int[]{0, -1})).isEqualTo(2);
        assertThat(longestConsecutive(new int[]{})).isEqualTo(0);
    }

    @Test
    public void test2() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q128LongestConsecutiveSequence.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(longestConsecutive(arr)).isEqualTo(5001);
    }

    @Test
    public void test3() {
        assertThat(longestConsecutive(new int[]{0, 1, 2, 4, 8, 5, 6, 7, 9, 3, 55, 88, 77, 99, 999999999})).isEqualTo(10);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int cnt = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                cnt++;
                max = Math.max(max, cnt);
            } else if (nums[i] != nums[i - 1]) {
                cnt = 1;
            }
        }
        return max;
    }

}
