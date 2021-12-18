package shane.programmers.lv3;

import org.junit.jupiter.api.Assertions;

public class NQueen_Failed {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution(4));
    }

    public static int solution(int n) {
        int[][] arr = new int[n][n];
        return calc(arr, 0, n);
    }

    private static void process(int[][] temp, int[] point) {
        int x = point[1];
        int y = point[0];
        for (int i = 0; i < temp.length; i++) {
            temp[y][i] = 1;
            temp[i][x] = 1;
        }

        for (int i = 0; i < temp.length; i++) {
            // 좌상
            try {
                temp[y - i][x - i] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            // 좌하
            try {
                temp[y + i][x - i] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            // 우상
            try {
                temp[y - i][x + i] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            //우하
            try {
                temp[y - i][x - i] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
            }

        }
    }

    private static int calc(int[][] arr, int current, int remain) {
        if (remain == 0)
            return 1;
        int sum = 0;
        for (int i = current; i < arr.length * arr.length; i++) {
            int x = i % arr.length;
            int y = i / arr.length;
            int[] point = new int[]{y, x};
            if (arr[y][x] == 0) {
                int[][] temp = arr.clone();
                process(temp, point);
                sum += calc(temp, i + 1, remain - 1);
            }
        }
        return sum;
    }

}
