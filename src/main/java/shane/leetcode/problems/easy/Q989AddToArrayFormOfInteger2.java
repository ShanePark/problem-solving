package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 84.63%
 * Memory 43.9 MB Beats 55.33%
 */
public class Q989AddToArrayFormOfInteger2 {

    @Test
    public void test() {
        assertThat(addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1)).isEqualTo(List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        assertThat(addToArrayForm(new int[]{1, 2, 0, 0}, 34)).isEqualTo(List.of(1, 2, 3, 4));
        assertThat(addToArrayForm(new int[]{2, 7, 4}, 181)).isEqualTo(List.of(4, 5, 5));
        assertThat(addToArrayForm(new int[]{2, 1, 5}, 806)).isEqualTo(List.of(1, 0, 2, 1));
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        String num2 = String.valueOf(k);
        int index1 = 0;
        int index2 = 0;
        int length1 = num.length;
        int length2 = num2.length();

        List<Integer> answer = new ArrayList<>();
        int sum = 0;
        while (index1 < length1 || index2 < length2) {
            if (index1 < length1) {
                int n1 = num[length1 - 1 - index1++];
                sum += n1;
            }
            if (index2 < length2) {
                int n2 = num2.charAt(length2 - 1 - index2++) - '0';
                sum += n2;
            }
            answer.add(sum % 10);
            sum /= 10;
        }
        if (sum > 0)
            answer.add(sum);

        Collections.reverse(answer);
        return answer;
    }

}
