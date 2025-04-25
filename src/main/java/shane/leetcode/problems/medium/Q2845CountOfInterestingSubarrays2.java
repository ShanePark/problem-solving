package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2845CountOfInterestingSubarrays2 {

    @Test
    public void test() {
        assertThat(countInterestingSubarrays(List.of(3, 1, 9, 6), 3, 0)).isEqualTo(2);
        assertThat(countInterestingSubarrays(List.of(3, 2, 4), 2, 1)).isEqualTo(3);
    }

    @Test
    public void tle() {
        List<Integer> list = Arrays.stream(new int[100000]).boxed().collect(Collectors.toList());
        assertThat(countInterestingSubarrays(list, 3, 0)).isEqualTo(1666650000L);
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] prefixSum = new int[nums.size()];
        if (nums.get(0) % modulo == k) {
            prefixSum[0] = 1;
        }
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1];
            if (nums.get(i) % modulo == k) {
                prefixSum[i]++;
            }
        }

        long answer = 0;
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L);

        for (int sum : prefixSum) {
            int currentMod = sum % modulo;
            int target = (currentMod - k + modulo) % modulo;
            answer += countMap.getOrDefault(target, 0L);

            countMap.merge(currentMod, 1L, Long::sum);
        }

        return answer;
    }

}
