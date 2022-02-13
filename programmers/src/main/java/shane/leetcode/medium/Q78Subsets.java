package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q78Subsets {

    @Test
    void test() {
        Assertions.assertThat(subsets(new int[]{1, 2, 3})).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{1, 2, 3}),
                Arrays.asList(new Integer[]{2, 3}),
                Arrays.asList(new Integer[]{1, 3}),
                Arrays.asList(new Integer[]{3}),
                Arrays.asList(new Integer[]{1, 2}),
                Arrays.asList(new Integer[]{2}),
                Arrays.asList(new Integer[]{1}),
                Arrays.asList(new Integer[]{})
        );

        Assertions.assertThat(subsets(new int[]{0})).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{0}),
                Arrays.asList(new Integer[]{})
        );

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int length = (int) Math.pow(2, nums.length);
        int binaryLength = (int) (Math.log(length) / Math.log(2));
        for (int i = 0; i < length; i++) {
            String binary = String.format("%" + binaryLength + "s", Integer.toBinaryString(i));
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }

        return list;

    }
}
