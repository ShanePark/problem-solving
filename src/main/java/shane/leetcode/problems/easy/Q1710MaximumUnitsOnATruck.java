package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1710MaximumUnitsOnATruck {

    @Test
    public void test() {
        assertThat(maximumUnits(STool.convertToIntArray("[[1,3],[2,2],[3,1]]"), 4)).isEqualTo(8);
        assertThat(maximumUnits(STool.convertToIntArray("[[5,10],[2,5],[4,7],[3,9]]"), 10)).isEqualTo(91);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] boxType : boxTypes) {
            count.merge(boxType[1], boxType[0], Integer::sum);
        }

        List<Integer> keys = count.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < keys.size() && truckSize > 0; i++) {
            Integer key = keys.get(i);
            Integer numberOfBoxes = count.get(key);
            int load = Math.min(numberOfBoxes, truckSize);
            sum += key * load;
            truckSize -= load;
        }
        return sum;
    }
}
