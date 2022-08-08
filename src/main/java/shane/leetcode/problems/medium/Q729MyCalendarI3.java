package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 20 ms, faster than 97.06% of Java online submissions for My Calendar I.
 * Memory Usage: 42.8 MB, less than 98.42% of Java online submissions for My Calendar I.
 */
public class Q729MyCalendarI3 {

    @Test
    public void test() {
        MyCalendar c = new MyCalendar();
        assertThat(c.book(10, 20)).isEqualTo(true);
        assertThat(c.book(15, 25)).isEqualTo(false);
        assertThat(c.book(20, 30)).isEqualTo(true);
        assertThat(c.book(30, 50)).isEqualTo(true);
        assertThat(c.book(30, 31)).isEqualTo(false);
    }

    class MyCalendar {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> higher = treeMap.higherEntry(start);
            if (higher != null && end > higher.getValue()) {
                return false;
            }
            treeMap.put(end, start);
            return true;
        }
    }

}
