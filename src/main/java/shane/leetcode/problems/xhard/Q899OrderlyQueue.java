package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * can't pass first test
 */
public class Q899OrderlyQueue {

    @Test
    public void testFailed() {
        assertThat(orderlyQueue("kuh", 1)).isEqualTo("hku");
    }

    @Test
    public void test() {
        assertThat(orderlyQueue("v", 1)).isEqualTo("v");
        assertThat(orderlyQueue("baaca", 3)).isEqualTo("aaabc");
        assertThat(orderlyQueue("cba", 1)).isEqualTo("acb");
    }

    public String orderlyQueue(String s, int k) {

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        if (s.length() <= k) {
            list = list.stream().sorted().collect(Collectors.toList());
            return listToString(list);
        }

        Set<String> set = new HashSet<>();

        while (true) {
            int indexToRemove = -1;
            Character charToRemove = null;
            char first = list.get(k);
            for (int i = 0; i < k; i++) {
                char c = list.get(i);
                if (first < c && (charToRemove == null || c < charToRemove)) {
                    indexToRemove = i;
                    charToRemove = c;
                }
            }
            if (indexToRemove == -1) {
                for (int i = 0; i < k; i++) {
                    if (list.get(i) > list.get(i + 1)) {
                        indexToRemove = i;
                        charToRemove = list.get(i);
                    }
                }
            }
            if (indexToRemove == -1)
                break;
            list.remove(indexToRemove);
            list.add(charToRemove);
            String str = listToString(list);
            if (!set.add(str)) {
                break;
            }
        }

        return set.stream().sorted(Comparator.naturalOrder()).findFirst().orElse(s);
    }

    String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(c -> sb.append(c));
        return sb.toString();
    }

}
