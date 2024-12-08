package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime69msBeats27.70%
 */
public class Q2054TwoBestNonOverlappingEvents {


    @Test
    public void test() {
        assertThat(maxTwoEvents(Ps.intArray("[[10,83,53],[63,87,45],[97,100,32],[51,61,16]]"))).isEqualTo(85);
        assertThat(maxTwoEvents(Ps.intArray("[[1,3,2],[4,5,2],[2,4,3]]"))).isEqualTo(4);
        assertThat(maxTwoEvents(Ps.intArray("[[1,3,2],[4,5,2],[1,5,5]]"))).isEqualTo(5);
        assertThat(maxTwoEvents(Ps.intArray("[[1,5,3],[1,5,1],[6,6,5]]"))).isEqualTo(8);
    }

    public int maxTwoEvents(int[][] events) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));
        int maxOne = 0;
        int maxTwo = 0;
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];
            if (maxOne < value) {
                maxOne = value;
                tree.put(end, value);
            }
            Map.Entry<Integer, Integer> floorEntry = tree.floorEntry(start - 1);
            if (floorEntry == null)
                continue;
            int valTwo = floorEntry.getValue() + value;
            if (valTwo <= maxTwo) {
                continue;
            }
            maxTwo = valTwo;
        }
        return Math.max(maxOne, maxTwo);
    }

}
