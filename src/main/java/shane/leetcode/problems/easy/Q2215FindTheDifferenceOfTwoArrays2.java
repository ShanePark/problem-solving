package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 14 ms Beats 40.62%
 * Memory 43.9 MB Beats 5.87%
 */
public class Q2215FindTheDifferenceOfTwoArrays2 {

    @Test
    public void test() {
        assertThat(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6})).containsExactly(Arrays.asList(1, 3), Arrays.asList(4, 6));
        assertThat(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2})).containsExactly(Arrays.asList(3), Arrays.asList());
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        List<List<Integer>> answer = new ArrayList<>();
        Set<Integer> answerSet1 = new HashSet<>();
        Set<Integer> answerSet2 = new HashSet<>();

        for (int i : nums1) {
            if (!set2.contains(i)) {
                answerSet1.add(i);
            }
        }
        for (int i : nums2) {
            if (!set1.contains(i)) {
                answerSet2.add(i);
            }
        }

        answer.add(new ArrayList<>(answerSet1));
        answer.add(new ArrayList<>(answerSet2));
        return answer;
    }

}
