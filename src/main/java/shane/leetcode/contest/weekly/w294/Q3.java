package shane.leetcode.contest.weekly.w294;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3 {

    @Test
    public void test() {
        assertThat(minimumLines(Ps.intArray("[[72,98],[62,27],[32,7],[71,4],[25,19],[91,30],[52,73],[10,9],[99,71],[47,22],[19,30],[80,63],[18,15],[48,17],[77,16],[46,27],[66,87],[55,84],[65,38],[30,9],[50,42],[100,60],[75,73],[98,53],[22,80],[41,61],[37,47],[95,8],[51,81],[78,79],[57,95]]"))).isEqualTo(29);
        assertThat(minimumLines(Ps.intArray("[[36,9],[17,93],[34,4],[30,11],[11,41],[53,36],[5,92],[81,92],[28,36],[3,45],[72,33],[64,1],[4,70],[16,73],[99,20],[49,33],[47,74],[83,91]]"))).isEqualTo(17);
        assertThat(minimumLines(Ps.intArray("[[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]"))).isEqualTo(3);
        assertThat(minimumLines(Ps.intArray("[[3,4],[1,2],[7,8],[2,3]]"))).isEqualTo(1);
        assertThat(minimumLines(Ps.intArray("[[520951128,579980099],[644385748,960835095],[620325123,217237614],[95982874,931896905],[833706608,133586306],[921095744,450443971],[314964109,312733445],[376346249,204183285],[781180635,655774443],[562309938,240058201],[361640088,269867123],[295134181,466100213],[338643455,276021251],[711253948,733222933],[194967428,681640076],[746583980,448467758],[90894063,910891511],[844018159,140032612],[686446838,702217411],[88147980,403676127],[210264446,165316470]]")))
                .isEqualTo(20);
    }

    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int x = 4, y = 2;
        int cnt = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            int curX = stockPrices[i][1] - stockPrices[i - 1][1];
            int curY = stockPrices[i][0] - stockPrices[i - 1][0];
            int gcd = gcd(curX, curY);
            curX = curX / gcd;
            curY = curY / gcd;
            if (curX != x || curY != y)
                cnt++;
            x = curX;
            y = curY;
        }

        return cnt;
    }

    private int gcd(int curX, int curY) {
        int min = Math.min(curX, curY);
        while (min > 0) {
            if (curX % min == 0 && curY % min == 0)
                return min;
            min--;
        }
        return 1;
    }
}
