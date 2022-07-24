package shane.leetcode.contest.weekly.w303;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q4 {

    @Test
    public void test() {
        assertThat(countExcellentPairs(new int[]{1, 2, 3, 1}, 3)).isEqualTo(5);
        assertThat(countExcellentPairs(new int[]{5, 1, 1}, 10)).isEqualTo(0);
    }

    public long countExcellentPairs(int[] nums, int k) {
        long[] arr = new long[31];
        long answer = 0;
        Arrays.stream(nums).distinct().forEach(i -> arr[Integer.bitCount(i)]++);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (i + j >= k) {
                    long plus = arr[i] * arr[j];
                    if (plus > 0) {
                    }
                    answer += plus;
                }
            }
        }
        return answer;
    }

}
