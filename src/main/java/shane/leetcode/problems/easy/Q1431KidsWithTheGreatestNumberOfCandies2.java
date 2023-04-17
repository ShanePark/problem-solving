package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Runtime 4 ms Beats 13.79%
 * Memory 42.6 MB Beats 55.44%
 */
public class Q1431KidsWithTheGreatestNumberOfCandies2 {

    @Test
    public void test() {
        Assertions.assertThat(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3)).containsExactly(true, true, true, false, true);
        Assertions.assertThat(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1)).containsExactly(true, false, false, false, false);
        Assertions.assertThat(kidsWithCandies(new int[]{12, 1, 12}, 10)).containsExactly(true, false, true);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies)
                .mapToObj(candy -> (max <= candy + extraCandies))
                .collect(Collectors.toList());
    }

}
