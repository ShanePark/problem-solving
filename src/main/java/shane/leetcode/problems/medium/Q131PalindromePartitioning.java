package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 58 ms Beats 5.4%
 * Memory 206 MB Beats 5.12%
 */
public class Q131PalindromePartitioning {

    @Test
    public void test() {
        assertThat(partition("efe")).containsExactlyInAnyOrder(
                List.of("e", "f", "e"),
                List.of("efe")
        );
        assertThat(partition("aab")).containsExactlyInAnyOrder(
                List.of("a", "a", "b"),
                List.of("aa", "b")
        );
        assertThat(partition("a")).containsExactlyInAnyOrder(
                List.of("a")
        );
    }

    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();

        for (char c : s.toCharArray()) {
            List<List<String>> next = new ArrayList<>();
            for (List<String> strings : answer) {
                String last = strings.get(strings.size() - 1);
                List<String> clone = new ArrayList<>(strings);
                clone.set(strings.size() - 1, last + c);
                next.add(clone);
                if (isPalindrome(last)) {
                    List<String> clone2 = new ArrayList<>(strings);
                    clone2.add(String.valueOf(c));
                    next.add(clone2);
                }
            }
            if (answer.isEmpty()) {
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(c));
                next.add(list);
            }
            answer = next;
        }

        return answer.stream()
                .filter(list -> {
                    String last = list.get(list.size() - 1);
                    return isPalindrome(last);
                }).collect(Collectors.toList());
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
