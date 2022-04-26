package shane.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Time Limit Exceeded
 * 총 소요시간: 14222ms
 */
public class Q1291SequentialDigits {

    public static void main(String[] args) {
        assertThat(sequentialDigits(100, 300)).containsExactly(123, 234);
        assertThat(sequentialDigits(100, 300).size()).isEqualTo(2);

        assertThat(sequentialDigits(1000, 13000).size()).isEqualTo(7);
        assertThat(sequentialDigits(1000, 13000)).containsExactly(1234, 2345, 3456, 4567, 5678, 6789, 12345);
        long current = System.currentTimeMillis();

        int temp = sequentialDigits(178546104, 812704742).size();
        System.out.println(temp);

        System.out.println("총 소요시간: " + (System.currentTimeMillis() - current) + "ms");
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (check(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean check(int n) {
        String str = String.valueOf(n);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1) + 1)
                return false;
        }
        return true;
    }


}
