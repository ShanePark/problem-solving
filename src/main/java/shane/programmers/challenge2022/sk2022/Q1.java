package shane.programmers.challenge2022.sk2022;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    @Test
    void test() {
        Assertions.assertThat(solution(4578, new int[]{1, 4, 99, 35, 50, 1000})).isEqualTo(2308);
    }

    public int solution(int money, int[] costs) {
        List<Coin> list = new ArrayList<>();
        list.add(new Coin(1, costs[0]));
        list.add(new Coin(5, costs[1]));
        list.add(new Coin(10, costs[2]));
        list.add(new Coin(50, costs[3]));
        list.add(new Coin(100, costs[4]));
        list.add(new Coin(500, costs[5]));

        list.sort((o1, o2) -> (o1.pricePerUnit - o2.pricePerUnit) > 0 ? 1 : -1);
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            int unit = list.get(i).unit;
            int price = list.get(i).price;
            int coinCount = money / unit;
            result += coinCount * price;
            money = money % unit;

        }

        return result;
    }

    class Coin {
        int unit;
        int price;
        double pricePerUnit;

        public Coin(int unit, int price) {
            this.unit = unit;
            this.price = price;
            this.pricePerUnit = (double) price / unit;
        }

        @Override
        public String toString() {
            return "Coin{" +
                    "unit=" + unit +
                    ", price=" + price +
                    ", pricePerUnit=" + pricePerUnit +
                    '}';
        }
    }

}
