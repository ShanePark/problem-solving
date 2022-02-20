package shane.leetcode.contest.biweekly72;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q5998MaximumSplitofPositiveEvenIntegers2 {

    @Test
    void test() {
        Assertions.assertThat(maximumEvenSplit(12)).containsExactlyInAnyOrder(2L, 4L, 6L);
        Assertions.assertThat(maximumEvenSplit(7)).isEmpty();
        Assertions.assertThat(maximumEvenSplit(28).size()).isEqualTo(4);
        Assertions.assertThat(maximumEvenSplit(90).size()).isEqualTo(9);
        Assertions.assertThat(maximumEvenSplit(4)).containsExactly(4L);
    }

    static long total = 0;

    public List<Long> maximumEvenSplit(long finalSum) {
        total = finalSum;
        if (finalSum % 2 == 1) {
            return new ArrayList<>();
        }

        List<Long> list = new ArrayList<>();
        for(long h=2; finalSum>=h; h+=2) {
            list.add(h);
            finalSum -= h;
        }
        list.set(list.size() - 1, list.get(list.size() - 1) + finalSum);
        return list;

    }

}
