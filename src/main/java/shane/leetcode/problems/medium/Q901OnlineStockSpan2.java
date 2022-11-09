package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 24 ms Beats 99.45%
 * Memory 50.6 MB Beats 89.89%
 */
@SuppressWarnings("ALL")
public class Q901OnlineStockSpan2 {

    @Test
    public void test4() {
        StockSpanner stockSpanner = new StockSpanner();
        assertThat(stockSpanner.next(28)).isEqualTo(1);
        assertThat(stockSpanner.next(14)).isEqualTo(1);
        assertThat(stockSpanner.next(28)).isEqualTo(3);
        assertThat(stockSpanner.next(35)).isEqualTo(4);
        assertThat(stockSpanner.next(46)).isEqualTo(5);
        assertThat(stockSpanner.next(53)).isEqualTo(6);
        assertThat(stockSpanner.next(66)).isEqualTo(7);
        assertThat(stockSpanner.next(80)).isEqualTo(8);
        assertThat(stockSpanner.next(87)).isEqualTo(9);
        assertThat(stockSpanner.next(88)).isEqualTo(10);
    }

    class StockSpanner {

        List<Stock> list = new ArrayList<>();

        public StockSpanner() {
        }

        public int next(int price) {
            Stock stock = new Stock(price);
            for (int i = list.size() - 1; i >= 0; i--) {
                Stock s = list.get(i);
                if (s.price <= price) {
                    list.remove(i);
                    stock.addDay(s);
                }
            }
            list.add(stock);
            return stock.days;
        }
    }

    class Stock {
        int price;
        int days;

        public Stock(int price) {
            this.price = price;
            this.days = 1;
        }

        public void addDay(Stock s) {
            this.days += s.days;
        }

        @Override
        public String toString() {
            return "Stock{" +
                    "price=" + price +
                    ", days=" + days +
                    '}';
        }
    }

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

}
