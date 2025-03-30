package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4
 * ms
 * Beats
 * 92.83%
 */
public class Q763PartitionLabels3 {

    @Test
    public void test() {
        assertThat(partitionLabels("ababcbacadefegdehijhklij")).containsExactly(9, 7, 8);
        assertThat(partitionLabels("eccbbbbdec")).containsExactly(10);
    }

    public List<Integer> partitionLabels(String s) {
        int[] lastAppear = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastAppear[c - 'a'] = i;
        }

        List<Integer> answer = new ArrayList<>();
        for (int left = 0; left < s.length(); left++) {
            int cur = left;
            int right = lastAppear[s.charAt(left) - 'a'];
            while (cur <= right) {
                char c = s.charAt(cur);
                right = Math.max(right, lastAppear[c - 'a']);
                cur++;
            }
            answer.add(right - left + 1);
            left = right;
        }
        return answer;
    }


}
