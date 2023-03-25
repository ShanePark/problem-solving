package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;
import shane.leetcode.util.Leet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Merge Sort
 * Runtime 247 ms Beats 24.58%
 * Memory 53.9 MB Beats 40.37%
 */
public class Q912SortAnArray3 {

    @Test
    public void test() {
        assertThat(sortArray(new int[]{-50000, 50000})).isEqualTo(new int[]{-50000, 50000});
        assertThat(sortArray(new int[]{5, 2, 3, 1})).isEqualTo(new int[]{1, 2, 3, 5});
        assertThat(sortArray(new int[]{5, 1, 1, 2, 0, 0})).isEqualTo(new int[]{0, 0, 1, 1, 2, 5});
    }

    @Test
    public void test2() throws IOException {
        int[] arr = Arrays.stream(Leet.readFileText(this.getClass(), "Q912SortAnArray.txt").split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        assertThat(sortArray(arr)).isSorted();
    }

    public int[] sortArray(int[] nums) {
        List<Integer> list = divideAndConquer(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    private List<Integer> divideAndConquer(int[] nums, int left, int right) {
        if (left == right)
            return Collections.singletonList(nums[left]);
        List<Integer> lList = divideAndConquer(nums, left, (left + right) / 2);
        List<Integer> rList = divideAndConquer(nums, (left + right) / 2 + 1, right);
        List<Integer> answer = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;
        while (l1 < lList.size() && l2 < rList.size()) {
            Integer lNum = lList.get(l1);
            Integer rNum = rList.get(l2);
            if (lNum < rNum) {
                answer.add(lNum);
                l1++;
            } else {
                answer.add(rNum);
                l2++;
            }
        }
        if (l1 < lList.size()) {
            answer.addAll(lList.subList(l1, lList.size()));
        }
        if (l2 < rList.size()) {
            answer.addAll(rList.subList(l2, rList.size()));
        }
        return answer;
    }


}
