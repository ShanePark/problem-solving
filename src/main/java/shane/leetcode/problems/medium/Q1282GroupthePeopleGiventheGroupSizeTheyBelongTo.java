package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1282GroupthePeopleGiventheGroupSizeTheyBelongTo {

    @Test
    void test() {
        List<List<Integer>> result = groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        Assertions.assertThat(result).hasSize(3);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> value = map.getOrDefault(size, new ArrayList<>());
            value.add(i);
            if (value.size() == size) {
                list.add(value);
                map.remove(size);
            } else {
                map.put(size, value);
            }
        }
        return list;
    }

}
