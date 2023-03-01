package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 65 ms, faster than 31.21% of Java online submissions for Find Duplicate File in System.
 * Memory Usage: 71.8 MB, less than 32.27% of Java online submissions for Find Duplicate File in System.
 */
public class Q609FindDuplicateFileInSystem {

    @Test
    public void test() {
        assertThat(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}))
                .isEqualTo(Ps.strList("[[\"root/a/2.txt\",\"root/c/d/4.txt\",\"root/4.txt\"],[\"root/a/1.txt\",\"root/c/3.txt\"]]"));
        assertThat(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"}))
                .isEqualTo(Ps.strList("[[\"root/a/2.txt\",\"root/c/d/4.txt\"],[\"root/a/1.txt\",\"root/c/3.txt\"]]"));
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] arr = path.split(" ");
            String parent = arr[0];
            for (int i = 1; i < arr.length; i++) {
                String data = arr[i];
                int delimiter = data.indexOf('(');
                String fileName = data.substring(0, delimiter);
                String content = data.substring(delimiter + 1, data.length() - 1);
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(parent + "/" + fileName);
                map.put(content, list);
            }
        }
        return map.values().stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }

}
