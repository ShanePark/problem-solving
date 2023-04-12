package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 98.32%
 * Memory 42.4 MB Beats 84.49%
 */
public class Q71SimplifyPath3 {

    @Test
    void test() {
        assertThat(simplifyPath("/../..ga/b/.f..d/..../e.baaeeh./.a")).isEqualTo("/..ga/b/.f..d/..../e.baaeeh./.a");
        assertThat(simplifyPath("/...")).isEqualTo("/...");
        assertThat(simplifyPath("/../")).isEqualTo("/");
        assertThat(simplifyPath("/home/")).isEqualTo("/home");
        assertThat(simplifyPath("/home//foo/")).isEqualTo("/home/foo");
        assertThat(simplifyPath("/a/./b/../../c/")).isEqualTo("/c");
        assertThat(simplifyPath("/a/../../b/../c//.//")).isEqualTo("/c");
        assertThat(simplifyPath("/a//b////c/d//././/..")).isEqualTo("/a/b/c");
        assertThat(simplifyPath("/home/../../..")).isEqualTo("/");
    }

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            if (!s.equals("..")) {
                deque.addLast(s);
                continue;
            }
            if (!deque.isEmpty()) {
                deque.pollLast();
            }
        }

        if (deque.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

}
