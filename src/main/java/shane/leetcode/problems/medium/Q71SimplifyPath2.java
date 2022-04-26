package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Q71SimplifyPath2 {

    @Test
    void test() {
        Assertions.assertThat(simplifyPath("/home/")).isEqualTo("/home");
        Assertions.assertThat(simplifyPath("/../")).isEqualTo("/");
        Assertions.assertThat(simplifyPath("/home//foo/")).isEqualTo("/home/foo");
        Assertions.assertThat(simplifyPath("/a/./b/../../c/")).isEqualTo("/c");
        Assertions.assertThat(simplifyPath("/a/../../b/../c//.//")).isEqualTo("/c");
        Assertions.assertThat(simplifyPath("/a//b////c/d//././/..")).isEqualTo("/a/b/c");
        Assertions.assertThat(simplifyPath("/home/../../..")).isEqualTo("/");
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else {
                if (!dir.equals(".") && !dir.equals("..") && !dir.equals("")) {
                    stack.push(dir);
                }
            }
        }
        path = "";
        while (!stack.isEmpty()) {
            path = "/" + stack.pop() + path;
        }
        return path.length() == 0 ? "/" : path;
    }

}
