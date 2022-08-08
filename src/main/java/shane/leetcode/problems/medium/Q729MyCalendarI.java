package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 95 ms, faster than 26.38% of Java online submissions for My Calendar I.
 * Memory Usage: 55.3 MB, less than 10.91% of Java online submissions for My Calendar I.
 */
public class Q729MyCalendarI {

    @Test
    public void test() {
        MyCalendar c = new MyCalendar();
        assertThat(c.book(10, 20)).isEqualTo(true);
        assertThat(c.book(15, 25)).isEqualTo(false);
        assertThat(c.book(20, 30)).isEqualTo(true);
    }

    class MyCalendar {

        private List<int[]> books = new ArrayList<>();

        public boolean book(int start, int end) {
            for (int[] book : books)
                if (Math.max(book[0], start) < Math.min(book[1], end))
                    return false;
            books.add(new int[]{start, end});
            return true;
        }
    }

}
