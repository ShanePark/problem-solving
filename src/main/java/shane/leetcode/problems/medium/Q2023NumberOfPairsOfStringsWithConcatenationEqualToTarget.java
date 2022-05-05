package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2023NumberOfPairsOfStringsWithConcatenationEqualToTarget {

    @Test
    public void test() {
        assertThat(numOfPairs(new String[]{"777", "7", "77", "77"}, "7777")).isEqualTo(4);
        assertThat(numOfPairs(new String[]{"123", "4", "12", "34"}, "1234")).isEqualTo(2);
        assertThat(numOfPairs(new String[]{"1", "1", "1"}, "11")).isEqualTo(6);
    }

    public int numOfPairs(String[] nums, String target) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String num : nums) {
            map.putIfAbsent(num.length(), new ArrayList<>());
            List<String> list = map.get(num.length());
            list.add(num);
        }

        int cnt = 0;
        for (Integer key : map.keySet()) {
            List<String> list1 = map.get(key);
            if (target.length() == key * 2) {
                for (int i = 0; i < list1.size(); i++) {
                    for (int j = i + 1; j < list1.size(); j++) {
                        if (target.equals(list1.get(i) + list1.get(j)))
                            cnt++;
                        if (target.equals(list1.get(j) + list1.get(i)))
                            cnt++;
                    }
                }
            } else {
                List<String> list2 = map.get(target.length() - key);
                if (list2 == null)
                    continue;
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        if (target.equals(s1 + s2)) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

}
