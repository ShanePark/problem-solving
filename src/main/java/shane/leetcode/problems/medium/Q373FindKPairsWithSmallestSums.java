package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MLE (25 / 35 testcases passed)
 */
public class Q373FindKPairsWithSmallestSums {

    @Test
    public void test() {
        assertThat(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3)).containsExactly(
                List.of(1, 2),
                List.of(1, 4),
                List.of(1, 6)
        );
        assertThat(kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2)).containsExactly(
                List.of(1, 1),
                List.of(1, 1)
        );
        assertThat(kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3)).containsExactly(
                List.of(1, 3),
                List.of(2, 3)
        );
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                list.add(new Pair(nums1[i], nums2[j]));
            }
        }

        return list.stream()
                .sorted(Comparator.comparingInt(p -> p.sum))
                .map(p -> List.of(p.first, p.second))
                .limit(k)
                .collect(Collectors.toList());
    }

    class Pair {
        int first;
        int second;
        int sum;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
            this.sum = first + second;
        }
    }

}
