package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1710MaximumUnitsOnATruck3 {

    @Test
    public void test() {
        assertThat(maximumUnits(Ps.intArray("[[1,3],[2,2],[3,1]]"), 4)).isEqualTo(8);
        assertThat(maximumUnits(Ps.intArray("[[5,10],[2,5],[4,7],[3,9]]"), 10)).isEqualTo(91);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int result = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int min = Math.min(truckSize, boxTypes[i][0]);
            result += min * boxTypes[i][1];
            truckSize -= min;
        }
        return result;
    }
}
