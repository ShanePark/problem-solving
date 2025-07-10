package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 34ms
 * Beats19.23%
 */
public class Q3440RescheduleMeetingsForMaximumFreeTimeII {

    @Test
    public void test() {
        assertThat(maxFreeTime(10, new int[]{0, 3, 7, 9}, new int[]{1, 4, 8, 10})).isEqualTo(6);
        assertThat(maxFreeTime(5, new int[]{1, 3}, new int[]{2, 5})).isEqualTo(2);
        assertThat(maxFreeTime(10, new int[]{0, 7, 9}, new int[]{1, 8, 10})).isEqualTo(7);
        assertThat(maxFreeTime(5, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        TreeMap<Integer, Integer> gapSize = new TreeMap<>();
        final int LENGTH = startTime.length;
        for (int i = -1; i < LENGTH; i++) {
            int gap = ((i < LENGTH - 1) ? startTime[i + 1] : eventTime) - (i < 0 ? 0 : endTime[i]);
            if (gap > 0) {
                gapSize.merge(gap, 1, Integer::sum);
            }
        }
        int maxFree = 0;
        for (int i = 0; i < LENGTH; i++) {
            int left = i == 0 ? 0 : endTime[i - 1];
            int right = i == LENGTH - 1 ? eventTime : startTime[i + 1];
            if (right - left <= maxFree)
                continue;
            int gapLeft = startTime[i] - left;
            int gapRight = right - endTime[i];
            int duration = endTime[i] - startTime[i];
            if (!canFit(gapSize, gapLeft, gapRight, duration)) {
                maxFree = Math.max(maxFree, right - left - duration);
                continue;
            }
            maxFree = right - left;
        }
        return maxFree;
    }

    private boolean canFit(TreeMap<Integer, Integer> gapSize, int gapLeft, int gapRight, int duration) {
        gapSize.merge(gapLeft, -1, Integer::sum);
        if (gapSize.get(gapLeft) == 0) {
            gapSize.remove(gapLeft);
        }
        gapSize.merge(gapRight, -1, Integer::sum);
        if (gapSize.get(gapRight) == 0) {
            gapSize.remove(gapRight);
        }
        boolean answer = !gapSize.isEmpty() && gapSize.lastKey() >= duration;
        gapSize.merge(gapLeft, 1, Integer::sum);
        gapSize.merge(gapRight, 1, Integer::sum);
        return answer;
    }

}
