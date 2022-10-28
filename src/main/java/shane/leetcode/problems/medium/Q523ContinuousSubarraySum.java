package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

public class Q523ContinuousSubarraySum {

    @Test
    public void test() {
        assertThat(checkSubarraySum(new int[]{1, 0, 1, 0, 1}, 4)).isFalse();
        assertThat(checkSubarraySum(new int[]{5, 0, 0, 0}, 3)).isTrue();
        assertThat(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)).isTrue();
        assertThat(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)).isTrue();
        assertThat(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)).isFalse();
    }

    /**
     * It takes eternity
     * @throws IOException
     */
    @Test
    public void tle() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q523ContinuousSubarraySum.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(checkSubarraySum(arr, 2000000000)).isEqualTo(false);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> before = new HashSet<>();
        for (int num : nums) {
            int mod = num % k;
            Set<Integer> set = new HashSet<>();
            set.add(mod);
            for (Integer i : before) {
                int sum = (i + num) % k;
                if (sum == 0)
                    return true;
                set.add(sum);
            }
            before = set;
        }
        return false;
    }

}
