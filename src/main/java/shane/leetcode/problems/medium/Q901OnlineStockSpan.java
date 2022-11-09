package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2302 ms Beats 5.3%
 * Memory 70.5 MB Beats 63.74%
 */
public class Q901OnlineStockSpan {

    @Test
    public void test() {
        StockSpanner stockSpanner = new StockSpanner();
        assertThat(stockSpanner.next(100)).isEqualTo(1);
        assertThat(stockSpanner.next(80)).isEqualTo(1);
        assertThat(stockSpanner.next(60)).isEqualTo(1);
        assertThat(stockSpanner.next(70)).isEqualTo(2);
        assertThat(stockSpanner.next(60)).isEqualTo(1);
        assertThat(stockSpanner.next(75)).isEqualTo(4);
        assertThat(stockSpanner.next(85)).isEqualTo(6);
    }

    @Test
    public void test2() {
        StockSpanner stockSpanner = new StockSpanner();
        assertThat(stockSpanner.next(29)).isEqualTo(1);
        assertThat(stockSpanner.next(91)).isEqualTo(2);
        assertThat(stockSpanner.next(62)).isEqualTo(1);
        assertThat(stockSpanner.next(76)).isEqualTo(2);
        assertThat(stockSpanner.next(51)).isEqualTo(1);
    }

    @Test
    public void test3() {
        StockSpanner stockSpanner = new StockSpanner();
        assertThat(stockSpanner.next(32)).isEqualTo(1);
        assertThat(stockSpanner.next(82)).isEqualTo(2);
        assertThat(stockSpanner.next(73)).isEqualTo(1);
        assertThat(stockSpanner.next(99)).isEqualTo(4);
        assertThat(stockSpanner.next(91)).isEqualTo(1);
    }

    class StockSpanner {

        List<Integer> list = new ArrayList<>();

        public StockSpanner() {
        }

        public int next(int price) {
            list.add(price);
            int cnt = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) <= price) {
                    cnt++;
                } else {
                    break;
                }
            }
            return cnt;
        }
    }

}
