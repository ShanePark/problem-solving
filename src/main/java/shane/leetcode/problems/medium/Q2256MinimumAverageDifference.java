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
 * Runtime 23 ms Beats 73.58%
 * Memory 71.2 MB Beats 82.75%
 */
public class Q2256MinimumAverageDifference {

    @Test
    public void test() {
        assertThat(minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3})).isEqualTo(3);
        assertThat(minimumAverageDifference(new int[]{0})).isEqualTo(0);
    }

    @Test
    public void test2() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q2256MinimumAverageDifference.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(minimumAverageDifference(arr)).isEqualTo(29403);
    }

    public int minimumAverageDifference(int[] nums) {
        long leftSum = nums[0];
        long rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        long minAvgDiff = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < nums.length; i++) {
            long avgLeft = leftSum / (i + 1);
            long avgRight = (i == nums.length - 1) ? 0 : (rightSum / (nums.length - i - 1));
            long avgDiff = Math.abs(avgLeft - avgRight);
            if (minAvgDiff > avgDiff) {
                minAvgDiff = avgDiff;
                answer = i;
            }

            if (i == nums.length - 1) {
                break;
            }
            leftSum += nums[i + 1];
            rightSum -= nums[i + 1];
        }

        return answer;
    }

}
