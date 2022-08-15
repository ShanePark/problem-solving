package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime: 8 ms, faster than 64.08% of Java online submissions for Roman to Integer.
 * Memory Usage: 46.9 MB, less than 26.48% of Java online submissions for Roman to Integer.
 */
public class Q13RomantoInteger2 {

    @Test
    public void test() {
        Assertions.assertEquals(3, romanToInt("III"));
        Assertions.assertEquals(58, romanToInt("LVIII"));
        Assertions.assertEquals(1994, romanToInt("MCMXCIV"));
        Assertions.assertEquals(621, romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int before = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (0 < before && before < value) {
                sum += (value - before);
                before = 0;
            } else {
                sum += before;
                before = value;
            }
        }

        return sum + before;
    }

}
