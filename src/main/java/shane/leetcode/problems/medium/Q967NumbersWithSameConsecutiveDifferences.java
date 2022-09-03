package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 6 ms, faster than 47.50% of Java online submissions for Numbers With Same Consecutive Differences.
 * Memory Usage: 42 MB, less than 96.25% of Java online submissions for Numbers With Same Consecutive Differences.
 */
public class Q967NumbersWithSameConsecutiveDifferences {

    @Test
    public void test() {
        assertThat(numsSameConsecDiff(3, 7)).containsExactlyInAnyOrder(181, 292, 707, 818, 929);
        assertThat(numsSameConsecDiff(2, 1)).containsExactlyInAnyOrder(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98);
        assertThat(numsSameConsecDiff(2, 0)).containsExactlyInAnyOrder(11, 22, 33, 44, 55, 66, 77, 88, 99);
    }

    @Test
    public void testNumber() {
        Number nine = new Number(9);
        assertThat(nine.getLength()).isEqualTo(1);
        Number ten = new Number(10);
        assertThat(ten.getLength()).isEqualTo(2);
        Number ninetyNine = new Number(99);
        assertThat(ninetyNine.getLast()).isEqualTo(9);
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Number> q = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            q.add(new Number(i));
        }

        while (!q.isEmpty()) {
            Number num = q.poll();
            if (num.getLength() == n) {
                list.add(num.val);
            } else {
                q.addAll(num.nextNumbers(k));
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    class Number {
        int val;

        public int getLast() {
            return val % 10;
        }

        public Number(int cur) {
            this.val = cur;
        }

        public int getLength() {
            return (int) Math.log10(val) + 1;
        }

        public List<Number> nextNumbers(int k) {
            List<Number> list = new ArrayList<>();
            if (getLast() >= k) {
                list.add(new Number(val * 10 + getLast() - k));
            }
            if (k != 0 && getLast() + k < 10) {
                list.add(new Number(val * 10 + getLast() + k));
            }
            return list;
        }
    }

}
