package shane.leetcode.contest.weekly.w301;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3 {

    @Test
    public void test() {
        assertThat(canChange("_R", "R_")).isEqualTo(false);
        assertThat(canChange("_L__R__R_", "L______RR")).isEqualTo(true);
        assertThat(canChange("R_L_", "__LR")).isEqualTo(false);
    }

    public boolean canChange(String start, String target) {
        char[] arr1 = start.toCharArray();
        char[] arr2 = target.toCharArray();
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                if (arr1[i] == 'L') {
                    return false;
                } else if (arr1[i] == '_') {
                    if (arr2[i] == 'R')
                        return false;
                    if (!findL(arr1, i)) {
                        return false;
                    }
                } else if (arr1[i] == 'R') {
                    if (arr2[i] == 'L')
                        return false;
                    if (!moveRight(arr1, i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean moveRight(char[] arr, int i) {
        if (i == arr.length)
            return false;
        if (arr[i + 1] == '_') {
            arr[i] = '_';
            arr[i + 1] = 'R';
            return true;
        } else if (arr[i + 1] == 'R') {
            if (moveRight(arr, i + 1)) {
                return moveRight(arr, i);
            }
        }
        return false;
    }

    private boolean findL(char[] arr, int i) {
        for (int j = i; j < arr.length; j++) {
            if (arr[j] == 'L') {
                arr[i] = 'L';
                arr[j] = '_';
                return true;
            } else if (arr[j] == 'R') {
                return false;
            }
        }
        return false;
    }

}
