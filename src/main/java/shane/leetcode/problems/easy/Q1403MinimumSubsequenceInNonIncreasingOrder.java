package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1403MinimumSubsequenceInNonIncreasingOrder {

    @Test
    public void test() {
        assertThat(minSubsequence(new int[]{1, 7, 4, 7, 1, 9, 4, 8, 8})).containsExactly(9, 8, 8);
        assertThat(minSubsequence(new int[]{4, 3, 10, 9, 8})).containsExactly(10, 9);
        assertThat(minSubsequence(new int[]{4, 4, 7, 6, 7})).containsExactly(7, 7, 6);
        assertThat(minSubsequence(new int[]{6})).containsExactly(6);
    }

    public List<Integer> minSubsequence(int[] nums) {
        int[] bucket = new int[101];
        int sum = 0;
        for (int num : nums) {
            bucket[num]++;
            sum += num;
        }

        List<Integer> answer = new ArrayList<>();
        sum /= 2;

        int right = 100;
        while (sum >= 0 && right > 0) {
            int possible = Math.min(bucket[right], sum / right + 1);
            for (int i = 0; i < possible; i++) {
                answer.add(right);
            }
            sum -= possible * right;
            right--;
        }

        return answer;
    }

}
