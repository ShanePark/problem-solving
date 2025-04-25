package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2845CountOfInterestingSubarrays {

    @Test
    public void test() {
        assertThat(countInterestingSubarrays(List.of(3, 2, 4), 2, 1)).isEqualTo(3);
        assertThat(countInterestingSubarrays(List.of(3, 1, 9, 6), 3, 0)).isEqualTo(2);
    }

    /**
     * 18 sec
     */
    @Test
    public void tle() {
        List<Integer> list = Arrays.stream(new int[100000]).boxed().collect(Collectors.toList());
        assertThat(countInterestingSubarrays(list, 3, 0)).isEqualTo(1666650000L);
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] prefixSum = new int[nums.size()];
        if (nums.get(0) % modulo == k) {
            prefixSum[0]++;
        }
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1];
            if (nums.get(i) % modulo == k) {
                prefixSum[i]++;
            }
        }
        long answer = 0;
        for (int left = 0; left < prefixSum.length; left++) {
            for (int right = left; right < prefixSum.length; right++) {
                int cnt = prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]);
                if (cnt % modulo == k) {
                    answer += 1;
                }
            }
        }
        return answer;
    }

}
