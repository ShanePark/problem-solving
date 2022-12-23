package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7 ms Beats 15.31%
 * Memory 41.9 MB Beats 71.81%
 */
public class Q309BestTimeToBuyAndSellStockWithCoolDown {

    @Test
    public void test() {
        assertThat(maxProfit(new int[]{1, 2, 3, 0, 2})).isEqualTo(3);
        assertThat(maxProfit(new int[]{1})).isEqualTo(0);
    }

    public int maxProfit(int[] prices) {
        List<Day>[] dp = new List[prices.length];
        Day notBuy = new Day(-1, 0, StatusEnum.CAN_BUY);
        Day buy = new Day(prices[0], 0, StatusEnum.HAS_STOCK);
        dp[0] = List.of(notBuy, buy);
        for (int i = 1; i < prices.length; i++) {
            List<Day> before = dp[i - 1];
            Day hasStock = null;
            Day isCoolDown = null;
            Day canBuy = null;
            int price = prices[i];
            for (Day day : before) {
                List<Day> cases = day.makeCases(price);
                for (Day aCase : cases) {
                    switch (aCase.status) {
                        case CAN_BUY:
                            hasStock = aCase.max(hasStock);
                            break;
                        case COOLING_DOWN:
                            isCoolDown = aCase.max(isCoolDown);
                            break;
                        case HAS_STOCK:
                            canBuy = aCase.max(canBuy);
                            break;
                    }
                }
            }
            List<Day> next = new ArrayList<>();

            if (hasStock != null)
                next.add(hasStock);
            if (isCoolDown != null)
                next.add(isCoolDown);
            if (canBuy != null)
                next.add(canBuy);
            dp[i] = next;
        }

        return dp[prices.length - 1].stream()
                .min(Comparator.comparingInt(d -> -d.profit))
                .get()
                .profit;
    }

    class Day {
        int boughtPrice;
        int profit;
        StatusEnum status;

        public Day(int boughtPrice, int profit, StatusEnum status) {
            this.boughtPrice = boughtPrice;
            this.profit = profit;
            this.status = status;
        }

        public List<Day> makeCases(int price) {
            if (status == StatusEnum.COOLING_DOWN) {
                return Collections.singletonList(new Day(boughtPrice, profit, StatusEnum.CAN_BUY));
            }
            List<Day> cases = new ArrayList<>();
            if (status == StatusEnum.HAS_STOCK && boughtPrice < price) {
                cases.add(new Day(-1, profit + (price - boughtPrice), StatusEnum.COOLING_DOWN));
            } else if (status == StatusEnum.CAN_BUY) { // do not have stock
                cases.add(new Day(price, profit, StatusEnum.HAS_STOCK));
            }
            cases.add(new Day(boughtPrice, profit, status)); // no action
            return cases;
        }

        public Day max(Day compare) {
            if (compare == null || compare.profit - compare.boughtPrice < profit - boughtPrice) {
                return this;
            }
            return compare;
        }

        @Override
        public String toString() {
            return "Day{" +
                    "boughtPrice=" + boughtPrice +
                    ", profit=" + profit +
                    ", status=" + status +
                    '}';
        }
    }

    enum StatusEnum {
        HAS_STOCK, COOLING_DOWN, CAN_BUY
    }

}
