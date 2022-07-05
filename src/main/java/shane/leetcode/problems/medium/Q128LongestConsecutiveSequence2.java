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

public class Q128LongestConsecutiveSequence2 {

    @Test
    public void test() {
        assertThat(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})).isEqualTo(4);
        assertThat(longestConsecutive(new int[]{0, -1})).isEqualTo(2);
        assertThat(longestConsecutive(new int[]{})).isEqualTo(0);
        assertThat(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})).isEqualTo(9);
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
        // 3sec 88ms
        assertThat(longestConsecutive(new int[]{0, 1, 2, 4, 8, 5, 6, 7, 9, 3, 55, 88, 77, 99, 999999999})).isEqualTo(10);
    }


    public int longestConsecutive(int[] nums) {
        int min = (int) 1e9;
        int max = -(int) 1e9;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }
        int answer = 0;
        int cnt = 0;
        for (int i = min; i <= max; i++) {
            if (set.contains(i)) {
                answer = Math.max(answer, ++cnt);
            } else {
                cnt = 0;
            }
        }
        return answer;
    }

}
