package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1710MaximumUnitsOnATruck2 {

    @Test
    public void test() {
        assertThat(maximumUnits(Ps.intArray("[[1,3],[2,2],[3,1]]"), 4)).isEqualTo(8);
        assertThat(maximumUnits(Ps.intArray("[[5,10],[2,5],[4,7],[3,9]]"), 10)).isEqualTo(91);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] bucket = new int[1001];
        for (int[] boxType : boxTypes) {
            bucket[boxType[1]] += boxType[0];
        }
        int sum = 0;
        for (int i = 1000; i >= 0 && truckSize > 0; i--) {
            int min = Math.min(truckSize, bucket[i]);
            sum += i * min;
            truckSize -= min;
        }
        return sum;
    }
}
