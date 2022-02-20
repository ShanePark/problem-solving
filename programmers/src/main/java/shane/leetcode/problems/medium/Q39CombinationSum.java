package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q39CombinationSum {

    @Test
    void test() {
        Assertions.assertThat(combinationSum(new int[]{2, 3, 6, 7}, 7)).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{2, 2, 3}),
                Collections.singletonList(7)
        );
        Assertions.assertThat(combinationSum(new int[]{2, 3, 5}, 8)).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{2, 2, 2, 2}),
                Arrays.asList(new Integer[]{2, 3, 3}),
                Arrays.asList(new Integer[]{3, 5})
        );
        Assertions.assertThat(combinationSum(new int[]{2}, 1)).isEmpty(
        );

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<ArrayObject> set = new HashSet<>();
        ArrayObject arr = new ArrayObject(new int[candidates.length]);
        dfs(0, arr, set, candidates, target);

        List<List<Integer>> answer = new ArrayList<>();
        for (ArrayObject arrayObject : set) {
            List<Integer> list = new ArrayList<>();
            int[] data = arrayObject.arr;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i]; j++) {
                    list.add(candidates[i]);
                }
            }
            answer.add(list);
        }

        return answer;
    }

    private void dfs(int sum, ArrayObject cur, Set<ArrayObject> set, int[] candidates, int target) {
        if (sum == target) {
            set.add(cur);
        }
        if (sum >= target)
            return;

        for (int i = 0; i < candidates.length; i++) {
            ArrayObject temp = new ArrayObject(cur);
            temp.arr[i]++;
            dfs(sum + candidates[i], temp, set, candidates, target);
        }

    }

    static class ArrayObject {
        int[] arr;

        public ArrayObject(int[] arr) {
            this.arr = arr;
        }

        public ArrayObject(ArrayObject target) {
            this.arr = Arrays.copyOf(target.arr, target.arr.length);
        }

        @Override
        public String toString() {
            return "ArrayObject{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayObject that = (ArrayObject) o;
            return Arrays.equals(arr, that.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }


}
