package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 100 ms, faster than 77.63% of Java online submissions for Earliest Possible Day of Full Bloom.
 * Memory Usage: 56.9 MB, less than 93.15% of Java online submissions for Earliest Possible Day of Full Bloom.
 */
public class Q2136EarliestPossibleDayOfFullBloom {

    @Test
    public void test() {
        assertThat(earliestFullBloom(
                new int[]{27, 5, 24, 17, 27, 4, 23, 16, 6, 26, 13, 17, 21, 3, 9, 10, 28, 26, 4, 10, 28, 2},
                new int[]{26, 9, 14, 17, 6, 14, 23, 24, 11, 6, 27, 14, 13, 1, 15, 5, 12, 15, 23, 27, 28, 12})
        ).isEqualTo(348);
        assertThat(earliestFullBloom(new int[]{1, 4, 3}, new int[]{2, 3, 1})).isEqualTo(9);
        assertThat(earliestFullBloom(new int[]{1, 2, 3, 2}, new int[]{2, 1, 2, 1})).isEqualTo(9);
        assertThat(earliestFullBloom(new int[]{1}, new int[]{1})).isEqualTo(2);
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            list.add(new Flower(plantTime[i], growTime[i]));
        }
        List<Flower> collect = list.stream()
                .sorted((a, b) -> {
                    if (a.growTime == b.growTime) {
                        return Integer.compare(b.plantTime, a.plantTime);
                    }
                    return Integer.compare(b.growTime, a.growTime);
                })
                .collect(Collectors.toList());
        int time = 0;
        int max = 0;
        for (Flower flower : collect) {
            time += flower.plantTime;
            int bloomTime = flower.bloom(time);
            max = Math.max(max, bloomTime);
        }

        return max;
    }

    class Flower {
        int plantTime;
        int growTime;

        public Flower(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "plantTime=" + plantTime +
                    ", growTime=" + growTime +
                    '}';
        }

        public int bloom(int time) {
            return time + growTime;
        }
    }

}
