package shane.leetcode.contest.weekly.w283;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * FAILED
 */
public class Q2197ReplaceNonCoprimeNumbersInArray {

    @Test
    void test() {
//        Assertions.assertThat(gcd(6, 2)).isEqualTo(2);
//        Assertions.assertThat(gcd(6, 7)).isEqualTo(1);
//        Assertions.assertThat(replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2})).containsExactly(12, 7, 6);
//        Assertions.assertThat(replaceNonCoprimes(new int[]{2, 2, 1, 1, 3, 3, 3})).containsExactly(2, 1, 1, 3);
//        Assertions.assertThat(replaceNonCoprimes(new int[]{517, 11, 121, 517, 3, 51, 3, 1887, 5})).containsExactly(5687, 1887, 5);
//        Assertions.assertThat(gcd(97561, 97561)).isEqualTo(97561);
//        Assertions.assertThat(replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561})).containsExactly(31, 97561);
        Assertions.assertThat(replaceNonCoprimes(new int[]{287, 41, 49, 287, 899, 23, 23, 20677, 5, 825})).containsExactly(2009, 20677, 825);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            Integer num1 = list.get(i);
            Integer num2 = list.get(i + 1);
            int gcd = gcd(num1, num2);
            if (gcd > 1) {
                list.remove(i);
                list.remove(i);
                int lcm = (int) ((long) num1 * num2 / gcd);
                list.add(i, lcm);
                i=0;
            }
        }
        return list;
    }

    private int gcd(Integer num1, Integer num2) {
        int min = Math.min(num1, num2);
        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

}
