package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Q729MyCalendarI4 {

    @Test
    public void test() {
        MyCalendar c = new MyCalendar();
        assertThat(c.book(10, 20)).isEqualTo(true);
        assertThat(c.book(15, 25)).isEqualTo(false);
        assertThat(c.book(20, 30)).isEqualTo(true);
    }

    class MyCalendar {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> lower = treeMap.lowerEntry(end);
            if (lower != null && start < lower.getValue()) {
                return false;
            }
            treeMap.put(start, end);
            return true;
        }
    }

}
