package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 52
 * ms
 * Beats
 * 46.09%
 */
public class Q1233RemoveSubFoldersFromTheFilesystem2 {

    @Test
    public void test() {
        assertThat(removeSubfolders(new String[]{"/a", "/ab/a"})).containsExactlyInAnyOrder("/a", "/ab/a");
        assertThat(removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"})).containsExactlyInAnyOrder("/a", "/c/d", "/c/f");
        assertThat(removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"})).containsExactlyInAnyOrder("/a");
        assertThat(removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"})).containsExactlyInAnyOrder("/a/b/c", "/a/b/ca", "/a/b/d");
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String before = " ";
        List<String> answer = new ArrayList<>();
        for (String f : folder) {
            if (isSubFolder(f, before)) {
                continue;
            }
            before = f;
            answer.add(f);
        }
        return answer;
    }

    private boolean isSubFolder(String f, String before) {
        if (f.length() < before.length())
            return false;
        if (f.equals(before))
            return true;
        return isSubFolder(getParent(f), before);
    }

    String getParent(String f) {
        if (f.isBlank())
            return f;
        return f.substring(0, f.lastIndexOf("/"));
    }

}
