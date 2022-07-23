package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q315CountOfSmallerNumbersAfterSelf2 {

    @Test
    public void t3() {
        assertThat(countSmaller(new int[]{-1})).containsExactly(0);
    }

    @Test
    public void test2() {
        int[] arr = new int[100000];
        assertThat(countSmaller(arr)).hasSize(100000);
    }

    @Test
    public void t2() {
        assertThat(countSmaller(new int[]{-1, -1})).containsExactly(0, 0);
        assertThat(countSmaller(new int[]{-1, 0})).containsExactly(0, 0);
    }

    @Test
    public void test() {
        assertThat(countSmaller(new int[]{5, 2, 6, 1})).containsExactly(2, 1, 1, 0);
    }

    /**
     * FAILED HERE
     */
    @Test
    public void t4() {
        assertThat(countSmaller(new int[]{2, 0, 1})).containsExactly(2, 0, 0);
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        int lastNumber = nums[nums.length - 1];
        countMap.put(lastNumber, 1);
        numbers.add(lastNumber);
        answer.add(0);

        for (int i = nums.length - 2; i >= 0; i--) {
            int n = nums[i];
            int index = binarySearch(numbers, n);
            if (index < 0) {
                answer.add(0, 0);
                numbers.add(0, n);
            } else {
                Integer numberAtIndex = numbers.get(index);
                Integer count = countMap.get(numberAtIndex);
                numbers.add(index + count, n);
                if (numberAtIndex == n) {
                    index -= count;
                }
                answer.add(0, index + count);
            }
            countMap.merge(n, 1, Integer::sum);
        }
        return answer;
    }

    private int binarySearch(List<Integer> numbers, int n) {
        int left = 0;
        int right = numbers.size() - 1;
        if (numbers.get(0) >= n)
            return -1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            Integer midNumber = numbers.get(mid);
            if (n <= midNumber) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
