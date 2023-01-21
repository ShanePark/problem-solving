package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 6.81%
 * Memory 42.4 MB Beats 69.66%
 */
public class Q969PancakeSorting {

    @Test
    public void test() {
        int[] arr = {3, 2, 4, 1};
        List<Integer> answer = pancakeSort(arr);
        for (Integer n : answer) {
            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[n - 1 - i];
                arr[n - 1 - i] = temp;
            }
        }
        System.out.println(answer);
        assertThat(arr).isSorted();
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> indexValue = new HashMap<>();
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexValue.put(i, arr[i]);
            valueIndex.put(arr[i], i);
        }

        for (int n = arr.length; n > 0; n--) {
            int index = valueIndex.get(n);
            if (index != n - 1) {
                flip(indexValue, valueIndex, index);
                flip(indexValue, valueIndex, n - 1);
                answer.add(index + 1);
                answer.add(n);
            }
        }
        return answer;
    }

    private void flip(Map<Integer, Integer> indexValue, Map<Integer, Integer> valueIndex, int index) {
        for (int i = 0; i <= index / 2; i++) {
            swap(indexValue, valueIndex, i, index - i);
        }
    }

    private void swap(Map<Integer, Integer> indexValue, Map<Integer, Integer> valueIndex, int i, int j) {
        int valueI = indexValue.get(i);
        int valueJ = indexValue.get(j);
        indexValue.put(i, valueJ);
        indexValue.put(j, valueI);
        valueIndex.put(valueJ, i);
        valueIndex.put(valueI, j);
    }

}
