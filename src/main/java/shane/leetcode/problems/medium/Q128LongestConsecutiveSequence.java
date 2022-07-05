package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q128LongestConsecutiveSequence {

    @Test
    public void test() throws IOException {
        // 800 ms
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q128LongestConsecutiveSequence.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(longestConsecutive(arr)).isEqualTo(5001);

        assertThat(longestConsecutive(new int[]{0, -1})).isEqualTo(2);
        assertThat(longestConsecutive(new int[]{})).isEqualTo(0);
        assertThat(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})).isEqualTo(4);
        assertThat(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})).isEqualTo(9);
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer beforeCount = map.get(num - 1);
            int currentCount = 1;
            if (beforeCount != null) {
                currentCount = beforeCount + 1;
            }
            map.put(num, currentCount);
            changeNext(num, currentCount, map);
        }

        if (map.isEmpty())
            return 0;

        return map.values().stream().max(Comparator.naturalOrder()).get();
    }

    private void changeNext(int num, int currentCount, Map<Integer, Integer> map) {
        Integer nextCount = map.get(num + 1);
        if (nextCount != null) {
            map.put(num + 1, currentCount + 1);
            changeNext(num + 1, currentCount + 1, map);
        }
    }
}
