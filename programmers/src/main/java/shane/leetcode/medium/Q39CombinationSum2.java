package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

@SuppressWarnings("ALL")
public class Q39CombinationSum2 {

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
        List<List<Integer>> list = new ArrayList<>();
        bt(list, new Stack<Integer>(), candidates, target, 0);
        return list;
    }

    private void bt(List<List<Integer>> list, Stack<Integer> temp, int[] candidates, int remain, int start) {
        if (remain == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (remain <= 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            temp.push(candidates[i]);
            bt(list, temp, candidates, remain - candidates[i], i);
            temp.pop();
        }
    }


}
