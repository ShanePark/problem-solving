package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface Q290WordPattern {
    public static void main(String[] args) {
        Assertions.assertEquals(true, wordPattern("abba", "dog cat cat dog"));
        Assertions.assertEquals(false, wordPattern("abba", "dog cat cat fish"));
        Assertions.assertEquals(false, wordPattern("abba", "dog dog dog dog"));
        Assertions.assertEquals(false, wordPattern("aaa", "aa aa aa aa"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if(pattern.length() != arr.length)
            return false;

        Map<String, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Character saved = map.get(arr[i]);
            if (saved == null) {
                map.put(arr[i], pattern.charAt(i));
                if (!set.add(pattern.charAt(i))) {
                    return false;
                }
            } else {
                if (saved != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
