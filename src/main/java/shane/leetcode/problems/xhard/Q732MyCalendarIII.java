package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Tried binary search but couldn't implement it. got a hint of treeMap from the discussion
 *
 * Runtime: 112 ms, faster than 76.41% of Java online submissions for My Calendar III.
 * Memory Usage: 43.1 MB, less than 91.89% of Java online submissions for My Calendar III.
 */
public class Q732MyCalendarIII {

    @Test
    public void test() {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        assertThat(myCalendarThree.book(10, 20)).isEqualTo(1);
        assertThat(myCalendarThree.book(50, 60)).isEqualTo(1);
        assertThat(myCalendarThree.book(10, 40)).isEqualTo(2);
        assertThat(myCalendarThree.book(5, 15)).isEqualTo(3);
        assertThat(myCalendarThree.book(5, 10)).isEqualTo(3);
        assertThat(myCalendarThree.book(25, 55)).isEqualTo(3);
    }

    class MyCalendarThree {
        private TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        public MyCalendarThree() {
        }

        public int book(int start, int end) {
            treeMap.merge(start, 1, Integer::sum);
            treeMap.merge(end, -1, Integer::sum);
            int currentCnt = 0;
            int max = 0;
            for (int cnt : treeMap.values())
                max = Math.max(max, currentCnt += cnt);
            return max;
        }
    }
}
