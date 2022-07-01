package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 금과은운반하기 {

    @Test
    public void test() {
        assertThat(solution(90, 500, new int[]{70, 70, 0}, new int[]{0, 0, 500}, new int[]{100, 100, 2}, new int[]{4, 8, 1})).isEqualTo(499);
        assertThat(solution(10, 10, new int[]{100}, new int[]{100}, new int[]{7}, new int[]{10})).isEqualTo(50);
    }

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = (long) 1e9 * 2 * (long) 1e5 * 2;
        while (left < right) {
            long mid = (left + right) / 2;
            Result result = check(mid, g, s, w, t);
            if (result.valid(a, b)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private Result check(long time, int[] g, int[] s, int[] w, int[] t) {
        int maxGold = 0;
        int maxSilver = 0;
        int maxTotal = 0;
        for (int i = 0; i < g.length; i++) {
            int travelTime = t[i];
            if (time < travelTime) {
                continue;
            }
            int gold = g[i];
            int silver = s[i];
            int weight = w[i];
            long moveCount = (time + travelTime) / (travelTime * 2);
            maxGold += Math.min(moveCount * weight, gold);
            maxSilver += Math.min(moveCount * weight, silver);
            maxTotal += Math.min(gold + silver, moveCount * weight);
        }
        return new Result(maxGold, maxSilver, maxTotal);
    }

    class Result {
        int maxGold;
        int maxSilver;
        int maxTotal;

        public Result(int maxGold, int maxSilver, int maxTotal) {
            this.maxGold = maxGold;
            this.maxSilver = maxSilver;
            this.maxTotal = maxTotal;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "maxGold=" + maxGold +
                    ", maxSilver=" + maxSilver +
                    ", maxTotal=" + maxTotal +
                    '}';
        }

        public boolean valid(int gold, int silver) {
            return this.maxGold >= gold && this.maxSilver >= silver && this.maxTotal >= gold + silver;
        }
    }

}
