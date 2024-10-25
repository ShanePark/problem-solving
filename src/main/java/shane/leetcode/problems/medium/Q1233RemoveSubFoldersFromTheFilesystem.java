package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Runtime52msBeats41.22%
 */
public class Q1233RemoveSubFoldersFromTheFilesystem {

    @Test
    public void test() {
        Assertions.assertThat(removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}))
                .containsExactlyInAnyOrder("/a", "/c/d", "/c/f");
        Assertions.assertThat(removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"})).containsExactlyInAnyOrder("/a");
        Assertions.assertThat(removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}))
                .containsExactlyInAnyOrder("/a/b/c", "/a/b/ca", "/a/b/d");
    }

    public List<String> removeSubfolders(String[] folder) {
        Folder root = new Folder("", null);
        List<String> answer = new ArrayList<>();

        Arrays.stream(folder)
                .sorted(Comparator.comparingInt(String::length))
                .forEach(f -> {
                    String[] dirs = f.split("/");
                    Folder parent = root;
                    for (String dir : dirs) {
                        if (dir.isEmpty())
                            continue;
                        Folder cur = parent.subFolders.get(dir);
                        if (cur != null && cur.last) {
                            parent = null;
                            break;
                        }
                        if (cur == null) {
                            cur = new Folder(dir, parent);
                            parent.subFolders.put(dir, cur);
                        }
                        parent = cur;
                    }
                    if (parent != null) {
                        parent.last = true;
                        answer.add(parent.fullPath);
                    }
                });
        return answer;
    }

    static class Folder {
        final String name;
        final Folder parent;
        String fullPath = "";
        Map<String, Folder> subFolders = new HashMap<>();
        boolean last = false;

        Folder(String name, Folder parent) {
            this.name = name;
            this.parent = parent;
            if (parent != null) {
                this.fullPath = parent.fullPath + "/" + name;
            }
        }

        @Override
        public String toString() {
            return "Folder{" +
                    "fullPath='" + fullPath + '\'' +
                    '}';
        }
    }

}
