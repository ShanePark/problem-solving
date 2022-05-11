package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q442FindAllDuplicatesInAnArray {

    @Test
    public void test() {
        assertThat(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})).containsExactly(2, 3);
        assertThat(findDuplicates(new int[]{1, 1, 2})).containsExactly(1);
        assertThat(findDuplicates(new int[]{1})).containsExactly();
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                list.add(num);
        }
        return list;
    }
}
