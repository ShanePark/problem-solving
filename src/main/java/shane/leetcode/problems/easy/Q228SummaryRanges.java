package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q228SummaryRanges {

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
        Integer start = null;
        Integer before = null;
        for (int num : nums) {
            if (start == null) {
                start = num;
                before = num;
            } else if (num == before + 1) {
                before = num;
            } else if (Integer.compare(start, before) == 0) {
                list.add(String.valueOf(start));
                start = num;
                before = num;
            } else {
                list.add(start + "->" + before);
                start = num;
                before = num;
            }
        }

        if (start != null) {
            if (Integer.compare(start, before) == 0) {
                list.add(String.valueOf(start));
            } else {
                list.add(start + "->" + before);
            }
        }

        return list;
    }
}
