package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2561RearrangingFruits {

    @Test
    public void test() {
        assertThat(minCost(new int[]{4, 2, 2, 2}, new int[]{1, 4, 1, 2})).isEqualTo(1);
        assertThat(minCost(new int[]{2, 3, 4, 1}, new int[]{3, 2, 5, 1})).isEqualTo(-1);
    }

    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> fruitFrequency = new TreeMap<>();
        int min = Integer.MAX_VALUE;

        for (int fruit : basket1) {
            fruitFrequency.merge(fruit, 1, Integer::sum);
            min = Math.min(min, fruit);
        }
        for (int fruit : basket2) {
            fruitFrequency.merge(fruit, -1, Integer::sum);
            min = Math.min(min, fruit);
        }

        List<Integer> fruitsToExchange = new ArrayList<>();
        for (var entry : fruitFrequency.entrySet()) {
            int frequencyDifference = entry.getValue();
            if (frequencyDifference % 2 != 0)
                return -1;

            int exchangeCount = Math.abs(frequencyDifference) / 2;
            for (int i = 0; i < exchangeCount; i++) {
                fruitsToExchange.add(entry.getKey());
            }
        }

        Collections.sort(fruitsToExchange);
        long totalCost = 0;
        for (int i = 0; i < fruitsToExchange.size() / 2; i++) {
            int directSwapCost = fruitsToExchange.get(i);
            int indirectSwapCost = 2 * min;
            totalCost += Math.min(directSwapCost, indirectSwapCost);
        }
        return totalCost;
    }

}
