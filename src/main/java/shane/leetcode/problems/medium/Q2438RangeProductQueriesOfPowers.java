package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 316ms
 * Beats5.38%
 */
public class Q2438RangeProductQueriesOfPowers {

    @Test
    public void test() {
        assertThat(productQueries(15, Ps.intArray("[[0,1],[2,2],[0,3]]"))).containsExactly(2, 4, 64);
        assertThat(productQueries(2, Ps.intArray("[[0,0]]"))).containsExactly(2);
    }

    @Test
    public void test2() {
        assertThat(productQueries(1000000000, Ps.intArray("[[0,0]]"))).containsExactly(512);
        assertThat(productQueries(919, Ps.intArray("[[5,5],[4,4],[0,1],[1,5],[4,6],[6,6],[5,6],[0,3],[5,5],[5,6],[1,2],[3,5],[3,6],[5,5],[4,4],[1,1],[2,4],[4,5],[4,4],[5,6],[0,4],[3,3],[0,4],[0,5],[4,4],[5,5],[4,6],[4,5],[0,4],[6,6],[6,6],[6,6],[2,2],[0,5],[1,4],[0,3],[2,4],[5,5],[6,6],[2,2],[2,3],[5,5],[0,6],[3,3],[6,6],[4,4],[0,0],[0,2],[6,6],[6,6],[3,6],[0,4],[6,6],[2,2],[4,6]]")))
                .containsExactly(256, 128, 2, 4194304, 16777216, 512, 131072, 128, 256, 131072, 8, 524288, 268435456, 256, 128, 2, 8192, 32768, 128, 131072, 16384, 16, 16384, 4194304, 128, 256, 16777216, 32768, 16384, 512, 512, 512, 4, 4194304, 16384, 128, 8192, 256, 512, 4, 64, 256, 147483634, 16, 512, 128, 1, 8, 512, 512, 268435456, 16384, 512, 4, 16777216);
    }

    final BigDecimal MOD = BigDecimal.valueOf(1e9 + 7);

    public int[] productQueries(int n, int[][] queries) {
        int mul = 1;
        while (mul < n) {
            mul *= 2;
        }
        List<Integer> list = new ArrayList<>();
        for (; 0 < n; mul /= 2) {
            if (mul <= n) {
                list.add(mul);
                n -= mul;
            }
        }
        Collections.sort(list);

        BigDecimal[] muls = new BigDecimal[list.size()];
        muls[0] = BigDecimal.valueOf(list.get(0));
        for (int i = 1; i < muls.length; i++) {
            muls[i] = muls[i - 1].multiply(BigDecimal.valueOf(list.get(i)));
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 0) {
                answer[i] = (muls[query[1]].divideAndRemainder(MOD)[1]).intValue();
                continue;
            }
            answer[i] = muls[query[1]].divide(muls[query[0] - 1], RoundingMode.DOWN).divideAndRemainder(MOD)[1].intValue();
        }
        return answer;
    }

}
