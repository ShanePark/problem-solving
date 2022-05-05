package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Q2032TwoOutOfThree {

    @Test
    public void twoOutOfThree() {
        assertThat(twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3})).containsExactlyInAnyOrder(3, 2);
        assertThat(twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2})).containsExactlyInAnyOrder(3, 2, 1);
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        stream(nums1).distinct().forEach(i -> map.merge(i, 1, Integer::sum));
        stream(nums2).distinct().forEach(i -> map.merge(i, 1, Integer::sum));
        stream(nums3).distinct().forEach(i -> map.merge(i, 1, Integer::sum));

        return map.entrySet().stream().filter(e -> e.getValue() >= 2).mapToInt(e -> e.getKey()).boxed().collect(Collectors.toList());
    }
}
