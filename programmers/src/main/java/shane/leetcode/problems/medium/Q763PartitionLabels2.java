package shane.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q763PartitionLabels2 {

    @Test
    public void test() {
        assertThat(partitionLabels("ababcbacadefegdehijhklij")).containsExactly(9, 7, 8);
        assertThat(partitionLabels("eccbbbbdec")).containsExactly(10);
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int cur = 0;
        int before = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            cur = Math.max(cur, lastIndex.get(s.charAt(i)));
            if (i == cur) {
                answer.add(i - before + 1);
                before = i + 1;
            }
        }

        return answer;
    }


}
