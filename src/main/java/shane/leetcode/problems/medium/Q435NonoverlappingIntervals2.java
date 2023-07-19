package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 92 ms Beats 12.41%
 * Memory 100.8 MB Beats 23.41%
 */
public class Q435NonoverlappingIntervals2 {

    @Test
    public void test() {
        assertThat(eraseOverlapIntervals(Ps.intArray("[[1,2],[2,3],[3,4],[1,3]]"))).isEqualTo(1);
        assertThat(eraseOverlapIntervals(Ps.intArray("[[1,2],[1,2],[1,2]]"))).isEqualTo(2);
        assertThat(eraseOverlapIntervals(Ps.intArray("[[1,2],[2,3]]"))).isEqualTo(0);
    }

    @Test
    public void fail() {
        assertThat(eraseOverlapIntervals(Ps.intArray("[[-25322,-4602],[-35630,-28832],[-33802,29009],[13393,24550],[-10655,16361],[-2835,10053],[-2290,17156],[1236,14847],[-45022,-1296],[-34574,-1993],[-14129,15626],[3010,14502],[42403,45946],[-22117,13380],[7337,33635],[-38153,27794],[47640,49108],[40578,46264],[-38497,-13790],[-7530,4977],[-29009,43543],[-49069,32526],[21409,43622],[-28569,16493],[-28301,34058]]")))
                .isEqualTo(19);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[1] == i2[1]) {
                return i2[0] - i1[0];
            }
            return i1[1] - i2[1];
        });
        int curEnd = Integer.MIN_VALUE;
        int overlap = 0;

        for (int[] interval : intervals) {
            if (curEnd <= interval[0]) {
                curEnd = interval[1];
                continue;
            }
            overlap++;
        }

        return overlap;
    }

}
