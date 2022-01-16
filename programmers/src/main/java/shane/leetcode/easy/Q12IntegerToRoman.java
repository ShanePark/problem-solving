package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedHashMap;

public class Q12IntegerToRoman {

    public static void main(String[] args) {
        Assertions.assertEquals("III", intToRoman(3));
        Assertions.assertEquals("LVIII", intToRoman(58));
        Assertions.assertEquals("MCMXCIV", intToRoman(1994));
    }

    public static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        for (Integer i : map.keySet()) {
            for (int j = 0; j < num / i; j++) {
                sb.append(map.get(i));
            }
            num = num % i;
        }

        return sb.toString();
    }
}
