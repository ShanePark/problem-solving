package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q438FindAllAnagramsinaString {

    @Test
    void test() {
        Assertions.assertThat(findAnagrams("cbaebabacd", "abc")).containsExactly(0, 6);
        Assertions.assertThat(findAnagrams("abab", "ab")).containsExactly(0, 1, 2);
        Assertions.assertThat(findAnagrams("afdkljflsdkjfsdlkjfdslkjfdslkjfkljlkjlkfdjslkfjsdlkjsdflksdjflkdsjfldskjksldfjlksdjflkdsjfsjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjfsdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", "z")).containsExactly(372);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }

        int[] temp = new int['z' - 'a' + 1];
        int[] answer = new int['z' - 'a' + 1];

        for (int i = 0; i < p.length(); i++) {
            answer[p.charAt(i) - 'a']++;
            temp[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(answer, temp)) {
            list.add(0);
        }

        for (int i = 1; i <= s.length() - p.length(); i++) {
            temp[s.charAt(i - 1) - 'a']--;
            temp[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(answer, temp)) {
                list.add(i);
            }
        }


        return list;

    }

}
