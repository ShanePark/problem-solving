package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q792NumberOfMatchingSubsequences2 {

    @Test
    public void test() {
        assertThat(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"})).isEqualTo(3);
        assertThat(numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"})).isEqualTo(2);
    }

    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            map.get(s.charAt(i)).add(i);
        }
        return (int) Arrays.stream(words)
                .filter(word -> isPossible(map, word))
                .count();
    }

    private boolean isPossible(Map<Character, List<Integer>> map, String word) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            index = binarySearch(index, map.get(c));
            if (index == -1)
                return false;
        }
        return true;
    }

    private int binarySearch(int min, List<Integer> list) {
        if (list.isEmpty() || list.get(list.size() - 1) <= min)
            return -1;

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            Integer value = list.get(mid);
            if (value <= min) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.get(left);
    }

}
