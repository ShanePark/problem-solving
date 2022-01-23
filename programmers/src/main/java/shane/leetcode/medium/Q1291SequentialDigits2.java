package shane.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("DuplicatedCode")
public class Q1291SequentialDigits2 {

    public static void main(String[] args) {
        assertThat(sequentialDigits(100, 300)).containsExactly(123, 234);
        assertThat(sequentialDigits(1000, 13000)).containsExactly(1234, 2345, 3456, 4567, 5678, 6789, 12345);

        long current = System.currentTimeMillis();
        assertThat(sequentialDigits(178546104, 812704742).size()).isEqualTo(0);
        System.out.println("총 소요시간: " + (System.currentTimeMillis() - current) + "ms");

        assertThat(sequentialDigits(58, 155)).containsExactly(67, 78, 89, 123);

    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (check(i)) {
                list.add(i);
            }

            int length = (int) (Math.log10(i)) + 1;
            int first = i / (int) Math.pow(10, length - 1);
            if (first + length > 10) {
                i = getNext(length) - 1;
            } else {
                int temp = 0;
                for (int j = 0; j < length; j++) {
                    temp += (first - 1 + length - j) * Math.pow(10, j);
                }
                if (i < temp) {
                    i = temp - 1;
                } else {
                    i = (first + 1) * (int) Math.pow(10, length - 1);
                }
            }
        }
        return list;
    }

    private static int getNext(int length) {
        int temp = 0;
        for (int j = 0; j < length + 1; j++) {
            temp += (length + 1 - j) * Math.pow(10, j);
        }
        return temp;
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
