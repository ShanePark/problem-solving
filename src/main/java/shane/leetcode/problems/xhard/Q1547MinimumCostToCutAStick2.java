package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1083 ms Beats 5.10%
 * Memory 48 MB Beats 6.68%
 */
@SuppressWarnings("DuplicatedCode")
public class Q1547MinimumCostToCutAStick2 {

    @Test
    void test() {
        assertThat(minCost(30, new int[]{18, 15, 13, 7, 5, 26, 25, 29})).isEqualTo(92);
        assertThat(minCost(7, new int[]{1, 3, 4, 5})).isEqualTo(16);
        assertThat(minCost(9, new int[]{5, 6, 1, 4, 2})).isEqualTo(22);
        assertThat(minCost(20, new int[]{1, 14, 18, 6, 17, 8, 10, 4, 13, 16, 7})).isEqualTo(71);
    }

    @Test
    void tle() {
        assertThat(minCost(36, new int[]{13, 17, 15, 18, 3, 22, 27, 6, 35, 7, 11, 28, 26, 20, 4, 5, 21, 10, 8})).isEqualTo(150);
    }

    Map<String, Integer> dp = new HashMap<>();

    public int minCost(int n, int[] cuts) {
        dp.clear();
        Arrays.sort(cuts);
        return minCost(0, n, cuts, 0, cuts.length);
    }

    private int minCost(int from, int until, int[] cuts, int cutsFrom, int cutsUntil) {
        if (cutsFrom == cutsUntil) {
            return 0;
        }
        if (cutsUntil - cutsFrom == 1) {
            return until - from;
        }

        String key = from + " " + until + " " + cutsFrom + " " + cutsUntil;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // 1. find the best cut place
        double minDistance = Integer.MAX_VALUE;
        int bestPrice = Integer.MAX_VALUE;
        double mid = ((double) from + until) / 2;

        for (int i = cutsFrom; i < cutsUntil; i++) {
            double distance = Math.abs(mid - cuts[i]);
            if (distance <= minDistance) {
                int leftCut = minCost(from, cuts[i], cuts, cutsFrom, i);
                int rightCut = minCost(cuts[i], until, cuts, i + 1, cutsUntil);
                int price = leftCut + rightCut;
                if (price < bestPrice) {
                    bestPrice = price;
                }
            }
        }

        dp.put(key, (until - from) + bestPrice);
        return dp.get(key);
    }

}
