package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2215FindTheDifferenceOfTwoArrays {

    @Test
    public void test() {
        assertThat(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6})).containsExactly(Arrays.asList(1, 3), Arrays.asList(4, 6));
        assertThat(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2})).containsExactly(Arrays.asList(3), Arrays.asList());
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        list1.addAll(Arrays.stream(nums1).filter(i -> Arrays.binarySearch(nums2, i) < 0).distinct().boxed().collect(Collectors.toList()));
        list2.addAll(Arrays.stream(nums2).filter(i -> Arrays.binarySearch(nums1, i) < 0).distinct().boxed().collect(Collectors.toList()));

        return answer;
    }

}
