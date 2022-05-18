package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1284MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix2 {

    @Test
    public void test() {
        // TLE : 55ms  play++ = 512
        assertThat(minFlips(STool.convertToIntArray("[[1,0,1],[0,1,0],[1,0,1]]"))).isEqualTo(9);
        assertThat(minFlips(STool.convertToIntArray("[[0]]"))).isEqualTo(0);
        assertThat(minFlips(STool.convertToIntArray("[[0,0],[0,1]]"))).isEqualTo(3);
        assertThat(minFlips(STool.convertToIntArray("[[1,0,0],[1,0,0]]"))).isEqualTo(-1);
    }

    final static int[][] areas = new int[][]{{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minFlips(int[][] mat) {
        boolean[] visited = new boolean[(int) Math.pow(2, 9)];
        int HEIGHT = mat.length;
        int WIDTH = mat[0].length;

        Queue<Integer> q = new LinkedList<>();
        q.add(toNumber(mat));

        int play = 0;

        int cur = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int poll = q.poll();
                if (poll == 0)
                    return cur;
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        int next = flip(poll, i, j, HEIGHT, WIDTH);
                        if (!visited[next]) {
                            q.offer(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            cur++;
        }

        return -1;
    }

    private int flip(int number, int i, int j, int height, int width) {
        int[][] arr = toArr(number, height, width);
        for (int[] area : areas) {
            int y = i + area[0];
            int x = j + area[1];
            if (0 <= x && x < width && 0 <= y && y < height) {
                arr[y][x] = arr[y][x] == 0 ? 1 : 0;
            }
        }
        return toNumber(arr);
    }

    private int[][] toArr(int number, int height, int width) {
        int length = height * width;
        String binary = Integer.toBinaryString(number);
        while (binary.length() < length) {
            binary = "0" + binary;
        }

        int[][] arr = new int[height][width];
        int cnt = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = binary.charAt(cnt++) - '0';
            }
        }

        return arr;
    }

    private int toNumber(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sum = sum * 2 + mat[i][j];
            }
        }
        return sum;
    }

}
