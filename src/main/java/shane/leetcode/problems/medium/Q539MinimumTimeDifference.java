package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime13msBeats26.67%
 */
public class Q539MinimumTimeDifference {

    @Test
    public void test() {
        assertThat(findMinDifference(List.of("23:59", "00:00"))).isEqualTo(1);
        assertThat(findMinDifference(List.of("00:00", "23:59", "00:00"))).isEqualTo(0);
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String timePoint : timePoints) {
            int min = toMin(timePoint);
            list.add(min);
            if (min < 720) {
                list.add(min + 1440);
            }
        }
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private int toMin(String timePoint) {
        int hour = Integer.parseInt(timePoint.substring(0, 2));
        int min = Integer.parseInt(timePoint.substring(3));
        return hour * 60 + min;
    }

}
