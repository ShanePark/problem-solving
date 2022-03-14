package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q71SimplifyPath {

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
        while (path.contains("//")) {
            path = path.replaceAll("//", "/");
        }
        String[] split = path.split("/");
        List<String> paths = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            paths.add(split[i]);
        }

        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).equals(".")) {
                paths.remove(i--);
            } else if (paths.get(i).equals("..")) {
                if (i > 1) {
                    paths.remove(i-- - 1);
                }
                paths.remove(i--);
            }
        }
        path = "/";
        for (String p : paths) {
            path = path + "/" + p;
        }
        while (path.contains("//")) {
            path = path.replaceAll("//", "/");
        }
        return (path.endsWith("/") && path.length() > 1) ? path.substring(0, path.length() - 1) : path;
    }
}
