package shane.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Q1389CreateTargetArrayintheGivenOrder {

    @Test
    void test() {
        Assertions.assertThat(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})).containsExactly(0, 4, 1, 3, 2);
        Assertions.assertThat(createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0})).containsExactly(0, 1, 2, 3, 4);
        Assertions.assertThat(createTargetArray(new int[]{1}, new int[]{0})).containsExactly(1);
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] answer = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            answer[i++] = integer;
        }

        return answer;

    }
}
