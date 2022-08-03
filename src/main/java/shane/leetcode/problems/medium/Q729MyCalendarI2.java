package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 306 ms, faster than 6.84% of Java online submissions for My Calendar I.
 * Memory Usage: 54.6 MB, less than 51.82% of Java online submissions for My Calendar I.
 */
public class Q729MyCalendarI2 {

    @Test
    public void test() {
        MyCalendar c = new MyCalendar();
        assertThat(c.book(10, 20)).isEqualTo(true);
        assertThat(c.book(15, 25)).isEqualTo(false);
        assertThat(c.book(20, 30)).isEqualTo(true);
    }

    class MyCalendar {

        TreeSet<int[]> tree = new TreeSet<>(Comparator.comparingInt(o -> o[0]));

        public boolean book(int start, int end) {
            for (int[] schedule : tree) {
                if (Math.max(schedule[0], start) < Math.min(schedule[1], end)) {
                    return false;
                }
            }
            tree.add(new int[]{start, end});
            return true;
        }

    }

}
