package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TLE
 */
public class Q316RemoveDuplicateLetters {

    @Test
    void test() {
        Assertions.assertThat(removeDuplicateLetters("bcabc")).isEqualTo("abc");
        Assertions.assertThat(removeDuplicateLetters("cbacdcbc")).isEqualTo("acdb");
        Assertions.assertThat(removeDuplicateLetters("abacb")).isEqualTo("abc");
    }

    public String removeDuplicateLetters(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<String> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                String poll = pq.poll();
                int index = poll.indexOf(String.valueOf(c));
                if (index < 0) {
                    list.add(poll + c);
                } else {
                    list.add(poll);
                    list.add(poll.replace(String.valueOf(c), "") + c);
                }
            }
            pq.addAll(list);
        }
        return pq.poll();
    }
}
