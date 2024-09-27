package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my iea
 */
public class Q731MyCalendarII {

    @Test
    public void test() {
        MyCalendarTwo calendar = new MyCalendarTwo();
        assertThat(calendar.book(10, 20)).isEqualTo(true);
        assertThat(calendar.book(50, 60)).isEqualTo(true);
        assertThat(calendar.book(10, 40)).isEqualTo(true);
        assertThat(calendar.book(5, 15)).isEqualTo(false);
        assertThat(calendar.book(5, 10)).isEqualTo(true);
        assertThat(calendar.book(25, 55)).isEqualTo(true);
    }

    class MyCalendarTwo {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();

        public boolean book(int start, int end) {
            map.merge(start, 1, Integer::sum);
            map.merge(end, -1, Integer::sum);
            int bookingCnt = 0;

            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                bookingCnt += e.getValue();
                if (bookingCnt > 2) {
                    map.merge(start, -1, Integer::sum);
                    map.merge(end, 1, Integer::sum);
                    return false;
                }
            }
            return true;
        }
    }


}
