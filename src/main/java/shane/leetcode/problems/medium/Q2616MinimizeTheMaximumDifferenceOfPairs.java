package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * misunderstood the question
 */
public class Q2616MinimizeTheMaximumDifferenceOfPairs {

    @Test
    public void test() {
        assertThat(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2)).isEqualTo(1);
        assertThat(minimizeMax(new int[]{4, 2, 1, 2}, 1)).isEqualTo(0);
    }

    @Test
    public void fail() {
        assertThat(minimizeMax(new int[]{8, 9, 1, 5, 4, 3, 6, 4, 3, 7}, 4)).isEqualTo(1);
        assertThat(minimizeMax(new int[]{1, 1, 0, 3}, 2)).isEqualTo(2);
        assertThat(minimizeMax(new int[]{1, 40, 40, 100, 2000, 3000}, 2)).isEqualTo(60);
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        List<Gap> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            Gap gap = new Gap(nums[i], nums[i + 1]);
            list.add(gap);
        }
        int answer = 0;
        for (int i = 0; i < p; i++) {
            int index = findMinIndex(list);
            Gap target = list.get(index);
            answer += target.gap;
            list.remove(index);
            if (0 < index && index < list.size() - 1) {
                Gap before = list.remove(index - 1);
                Gap after = list.remove(index - 1);
                Gap gap = new Gap(before.before, after.after);
                list.add(index - 1, gap);
            }
        }

        return answer;
    }

    private int findMinIndex(List<Gap> list) {
        int minGap = list.get(0).gap;
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            Gap gap = list.get(i);
            if (gap.gap < minGap) {
                minGap = gap.gap;
                index = i;
            }
        }
        return index;
    }

    class Gap {
        int before;
        int after;
        int gap;

        public Gap(int before, int after) {
            this.before = before;
            this.after = after;
            this.gap = after - before;
        }

        @Override
        public String toString() {
            return "Gap{" +
                    "before=" + before +
                    ", after=" + after +
                    ", gap=" + gap +
                    '}';
        }
    }

}
