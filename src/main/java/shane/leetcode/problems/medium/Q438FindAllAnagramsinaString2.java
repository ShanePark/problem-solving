package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Runtime 10 ms Beats 70.25%
 * Memory 43.3 MB Beats 77.41%
 */
public class Q438FindAllAnagramsinaString2 {

    @Test
    void test() {
        Assertions.assertThat(findAnagrams("afdkljflsdkjfsdlkjfdslkjfdslkjfkljlkjlkfdjslkfjsdlkjsdflksdjflkdsjfldskjksldfjlksdjflkdsjfsjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjfsdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", "z")).containsExactly(372);
        Assertions.assertThat(findAnagrams("abab", "ab")).containsExactly(0, 1, 2);
        Assertions.assertThat(findAnagrams("cbaebabacd", "abc")).containsExactly(0, 6);
        Assertions.assertThat(findAnagrams("a", "aaa")).isEmpty();
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return Collections.EMPTY_LIST;

        List<Integer> answer = new ArrayList<>();
        int[] arr = new int[26];
        int pLength = p.length();
        for (int i = 0; i < pLength; i++) {
            arr[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < pLength; i++) {
            arr[s.charAt(i) - 'a']--;
        }
        int diffCnt = 26 - (int) Arrays.stream(arr).filter(i -> i == 0).count();
        if (diffCnt == 0)
            answer.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - p.length());
            int oldCharCnt = ++arr[oldChar - 'a'];
            if (oldCharCnt == 0) {
                diffCnt--;
            } else if (oldCharCnt == 1) {
                diffCnt++;
            }
            int newCharCnt = --arr[newChar - 'a'];
            if (newCharCnt == 0) {
                diffCnt--;
            } else if (newCharCnt == -1) {
                diffCnt++;
            }
            if (diffCnt == 0) {
                answer.add(i - pLength + 1);
            }
        }
        return answer;
    }

}
