package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ofCourse TLE... (when k = 7)
 */
public class Q188BestTimeToBuyAndSellStockIV {

    @Test
    public void test() {
        assertThat(maxProfit(0, new int[]{1, 3})).isEqualTo(0);
        assertThat(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})).isEqualTo(7);
        assertThat(maxProfit(2, new int[]{2, 4, 1})).isEqualTo(2);
    }

    public int maxProfit(int k, int[] prices) {
        Queue<Status> q = new LinkedList<>();
        q.add(new Status());
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Status poll = q.poll();
                if (poll.cur == null) {
                    if (poll.transactionCnt < k) {
                        q.offer(poll.buy(price));
                    }
                } else if (poll.cur < price) {
                    Status sell = poll.sell(price);
                    max = Math.max(max, sell.sum);
                    if (sell.transactionCnt < k) {
                        q.offer(sell);
                    }
                }
                if (poll.transactionCnt < k)
                    q.offer(poll);
            }
        }
        return max;
    }

    class Status {
        int transactionCnt;
        Integer cur;
        int sum;

        public Status sell(int price) {
            Status status = new Status();
            status.transactionCnt = this.transactionCnt + 1;
            status.sum = this.sum + (price - this.cur);
            return status;
        }

        public Status buy(int price) {
            Status status = new Status();
            status.transactionCnt = this.transactionCnt;
            status.cur = price;
            status.sum = this.sum;
            return status;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "transactionCnt=" + transactionCnt +
                    ", cur=" + cur +
                    ", sum=" + sum +
                    '}';
        }
    }

}
