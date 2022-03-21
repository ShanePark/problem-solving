package shane.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q763PartitionLabels {

    @Test
    public void test() {
        assertThat(partitionLabels("ababcbacadefegdehijhklij")).containsExactly(9, 7, 8);
        assertThat(partitionLabels("eccbbbbdec")).containsExactly(10);
    }

    public List<Integer> partitionLabels(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        List<Integer> answer = new ArrayList<>();
        int index = 0;
        int before = 0;
        while (index < s.length()) {
            if (containsAny(list, set)) {
                index++;
                set.add(list.remove(0));
            } else {
                answer.add(index - before);
                before = index;
                index++;
                set.clear();
                if (list.size() > 0) {
                    set.add(list.remove(0));
                }
            }
        }
        answer.add(index - before);
        return answer;
    }

    private boolean containsAny(List<Character> list, Set<Character> set) {
        for (Character c : set) {
            if (list.contains(c)) {
                return true;
            }
        }
        return false;
    }

}
