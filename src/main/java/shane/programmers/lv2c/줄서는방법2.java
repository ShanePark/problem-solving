package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class 줄서는방법2 {

    @Test
    public void test() {
        assertThat(solution(3, 5)).containsExactly(3, 1, 2);
        assertThat(solution(10, 1)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public int[] solution(int n, long k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int i = 1; i < k; i++) {
            next(arr);
        }
        return arr;
    }

    private void next(int[] arr) {
        int left = arr.length - 2;
        while (left > 0 && arr[left] > arr[left + 1]) {
            left--;
        }
        int right = arr.length - 1;

        while (right > left && arr[right] <= arr[left])
            right--;
        swap(arr, left, right);

        int end = arr.length - 1;
        while (left + 1 < end) {
            swap(arr, left++ + 1, end--);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
