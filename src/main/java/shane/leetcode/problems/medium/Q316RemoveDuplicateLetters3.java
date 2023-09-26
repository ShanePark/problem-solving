package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q316RemoveDuplicateLetters3 {

    @Test
    void test() {
        Assertions.assertThat(removeDuplicateLetters("bcabc")).isEqualTo("abc");
        Assertions.assertThat(removeDuplicateLetters("cbacdcbc")).isEqualTo("acdb");
    }

    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        Set<Character> visited = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            cnt[c - 'a']--;
            if (!visited.add(c))
                continue;

            while (!stack.isEmpty() && c < stack.peek() && cnt[stack.peek() - 'a'] != 0) {
                visited.remove(stack.pop());
            }
            stack.push(c);
            visited.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

}
