package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q392IsSubsequence {

    @Test
    void test() {
        Assertions.assertThat(isSubsequence("abc", "ahbgdc")).isTrue();
        Assertions.assertThat(isSubsequence("axc", "ahbgdc")).isFalse();
    }

    public boolean isSubsequence(String s, String t) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        int index = 0;
        while (!q.isEmpty() && index < t.length()) {
            if (q.peek() == t.charAt(index)) {
                q.poll();
            }
            index++;
        }

        return q.isEmpty();

    }

}
