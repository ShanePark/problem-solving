package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 33.52%
 * Memory 40.8 MB Beats 73.61%
 */
public class Q228SummaryRanges3 {

    @Test
    void test() {
        assertThat(summaryRanges(new int[]{0, 1, 2, 4, 5, 7})).containsExactly("0->2", "4->5", "7");
        assertThat(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})).containsExactly("0", "2->4", "6", "8->9");
        assertThat(summaryRanges(new int[]{})).isEmpty();
        assertThat(summaryRanges(new int[]{-2147483648, -2147483647, 2147483647})).containsExactly("-2147483648->-2147483647", "2147483647");
        assertThat(summaryRanges(new int[]{-1000000000, -9999, 0, 1, 2, 10, 100, 1000, 999999999, 1000000000})).containsExactly("-1000000000", "-9999", "0->2", "10", "100", "1000", "999999999->1000000000");
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return Collections.emptyList();
        List<String> answer = new ArrayList<>();

        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (i == nums.length - 1 || cur + 1 < nums[i + 1]) {
                addRange(answer, start, cur);
                if (i < nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return answer;
    }

    private void addRange(List<String> answer, int start, int cur) {
        if (start == cur) {
            answer.add(String.valueOf(start));
            return;
        }
        answer.add(start + "->" + cur);
    }

}
