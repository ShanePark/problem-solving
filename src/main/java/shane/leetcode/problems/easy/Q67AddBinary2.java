package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

public class Q67AddBinary2 {

    public static void main(String[] args) {
        Assertions.assertEquals("100", addBinary("11", "1"));
        Assertions.assertEquals("10101", addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {

        int aLen = a.length();
        int bLen = b.length();
        StringBuffer sb = new StringBuffer();
        int save = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int temp = save;
            save = 0;
            int aIndex = aLen - 1 - i;
            int bIndex = bLen - 1 - i;
            if (aIndex >= 0) {
                temp += a.charAt(aIndex) - 48;
            }
            if (bIndex >= 0) {
                temp += b.charAt(bIndex) - 48;
            }
            if (temp >= 2) {
                save = temp / 2;
            }
            sb.insert(0, temp % 2);
        }

        while (save > 0) {
            int temp = save;
            save = save / 2;
            sb.insert(0, temp % 2);
        }

        return sb.toString();

    }


}
