package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1288RemoveCoveredIntervals {

    @Test
    void test() {
        Assertions.assertThat(removeCoveredIntervals(STool.convertToIntArray("[[1,4],[3,6],[2,8]]"))).isEqualTo(2);
        Assertions.assertThat(removeCoveredIntervals(STool.convertToIntArray("[[1,4],[2,3]]"))).isEqualTo(1);
    }

    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        loop:
        for (int[] interval : intervals) {
            for (int i = 0; i < list.size(); i++) {
                int[] ints = list.get(i);
                if (ints[0] <= interval[0] && interval[1] <= ints[1]) {
                    continue loop;
                } else if (interval[0] <= ints[0] && ints[1] <= interval[1]) {
                    list.remove(i--);
                }
            }
            list.add(interval);
        }
        return list.size();
    }

}
