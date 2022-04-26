package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1313DecompressRunLengthEncodedList {

    @Test
    void test() {
        Assertions.assertThat(decompressRLElist(new int[]{1, 2, 3, 4})).containsExactly(2, 4, 4, 4);
        Assertions.assertThat(decompressRLElist(new int[]{1, 1, 2, 3})).containsExactly(1, 3, 3);
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

}
