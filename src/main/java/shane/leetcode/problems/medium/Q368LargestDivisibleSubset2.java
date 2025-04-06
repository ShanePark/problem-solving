package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q368LargestDivisibleSubset2 {

    @Test
    public void test() {
        assertThat(largestDivisibleSubset(new int[]{1, 2, 3})).containsExactlyInAnyOrder(1, 2);
        assertThat(largestDivisibleSubset(new int[]{1, 2, 4, 8})).containsExactlyInAnyOrder(1, 2, 4, 8);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] lengths = new int[nums.length];
        int[] prev = new int[nums.length];
        int maxLength = 0;
        int maxEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            lengths[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && lengths[i] - 1 < lengths[j]) {
                    lengths[i] = lengths[j] + 1;
                    prev[i] = j;
                }
            }
            if (lengths[i] <= maxLength)
                continue;
            maxLength = lengths[i];
            maxEnd = i;
        }
        List<Integer> answer = new ArrayList<>();
        while (maxEnd >= 0) {
            answer.add(nums[maxEnd]);
            maxEnd = prev[maxEnd];
        }
        return answer;
    }

}
