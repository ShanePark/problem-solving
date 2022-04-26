package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1769MinimumNumberofOperationstoMoveAllBallstoEachBox {

    @Test
    void test() {
        Assertions.assertThat(minOperations("110")).containsExactly(1, 1, 3);
        Assertions.assertThat(minOperations("001011")).containsExactly(11, 8, 5, 4, 3, 4);
        Assertions.assertThat(minOperations("1")).containsExactly(0);
        Assertions.assertThat(minOperations("0")).containsExactly(0);
    }

    public int[] minOperations(String boxes) {
        int[] arr = new int[boxes.length()];
        int cnt = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if ((boxes.charAt(i) == '1')) {
                arr[0] += i;
                cnt++;
            }
        }

        for (int i = 1; i < boxes.length(); i++) {

            if (boxes.charAt(i - 1) == '1') {
                cnt--;
            }

            arr[i] = arr[i - 1] - cnt;

            if (boxes.charAt(i) == '1') {
                cnt--;
            }
        }

        return arr;
    }

}
