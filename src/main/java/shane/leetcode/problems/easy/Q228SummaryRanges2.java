package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Q228SummaryRanges2 {

    @Test
    void test() {
        Assertions.assertThat(summaryRanges(new int[]{0, 1, 2, 4, 5, 7})).containsExactly("0->2", "4->5", "7");
        Assertions.assertThat(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})).containsExactly("0", "2->4", "6", "8->9");
        Assertions.assertThat(summaryRanges(new int[]{})).isEmpty();
        Assertions.assertThat(summaryRanges(new int[]{-2147483648, -2147483647, 2147483647})).containsExactly("-2147483648->-2147483647", "2147483647");
        Assertions.assertThat(summaryRanges(new int[]{-1000000000, -9999, 0, 1, 2, 10, 100, 1000, 999999999, 1000000000})).containsExactly("-1000000000", "-9999", "0->2", "10", "100", "1000", "999999999->1000000000");
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                end++;
                i++;
            }
            list.add(start == end ? String.valueOf(nums[end]) : nums[start] + "->" + nums[end]);
            end++;
            start = end;
        }

        return list;
    }
}
