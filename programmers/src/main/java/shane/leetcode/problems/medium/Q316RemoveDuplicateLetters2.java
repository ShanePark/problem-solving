package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q316RemoveDuplicateLetters2 {

    @Test
    void test() {
        Assertions.assertThat(removeDuplicateLetters("bcabc")).isEqualTo("abc");
        Assertions.assertThat(removeDuplicateLetters("cbacdcbc")).isEqualTo("acdb");
        Assertions.assertThat(removeDuplicateLetters("abacb")).isEqualTo("abc");
    }

    public String removeDuplicateLetters(String s) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = indexMap.getOrDefault(c, new ArrayList<>());
            list.add(i);
            indexMap.putIfAbsent(c, list);
            set.add(c);
        }
        List<Character> keys = new ArrayList<>(set);
        Collections.sort(keys);

        StringBuffer sb = new StringBuffer();

        while (!keys.isEmpty()) {
            Character keyOfLoop = null;
            int minIndex = -1;
            int keyIndex = -1;
            keyCheck:
            for (int i = 0; i < keys.size(); i++) {
                Character key = keys.get(i);
                keyIndex = i;
                minIndex = indexMap.get(key).get(0);
                for (int j = i + 1; j < keys.size(); j++) {
                    Character tmpKey = keys.get(j);
                    List<Integer> tmpKeyIndexes = indexMap.get(tmpKey);
                    Integer maxIndex = tmpKeyIndexes.get(tmpKeyIndexes.size() - 1);
                    if (maxIndex < minIndex) {
                        continue keyCheck;
                    }
                }
                keyOfLoop = key;
                break;
            }
            sb.append(keyOfLoop);
            for (int i = keyIndex; i < keys.size(); i++) {
                Character key = keys.get(i);
                List<Integer> keyIndexes = indexMap.get(key);
                while (keyIndexes.get(0) < minIndex) {
                    keyIndexes.remove(0);
                }
            }

            keys.remove(keyIndex);
            indexMap.remove(keyOfLoop);

        }

        return sb.toString();
    }
}
