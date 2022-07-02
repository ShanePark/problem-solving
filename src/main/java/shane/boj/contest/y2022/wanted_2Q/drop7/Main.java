package shane.boj.contest.y2022.wanted_2Q.drop7;

/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {

    @Test
    public void test() {
        assertThat(findMin(STool.convertToIntArray("[[0, 0, 0, 0, 0, 0, 0]\n" +
                ",[0, 0, 0, 0, 0, 0, 0]\n" +
                ",[0, 0, 0, 0, 0, 0, 0]\n" +
                ",[0, 0, 0, 0, 0, 0, 0]\n" +
                ",[0, 0, 0, 4, 0, 2, 0]\n" +
                ",[0, 0, 0, 5, 0, 6, 0]\n" +
                ",[3, 3, 0, 7, 5, 6, 7]]"), 3)).isEqualTo(0);
    }

    private int findMin(int[][] arr, int ball) {
        int min = 49;
        for (int i = 0; i < 7; i++) {
            int[][] drop = drop(arr, i, ball);
            int bomb = bomb(drop);
            min = Math.min(min, bomb);
        }
        return min;
    }

    private int bomb(int[][] matrix) {
        int[][][] countMatrix = new int[7][7][2];
        for (int i = 0; i < 7; i++) {
            int cnt = 0;
            for (int j = 0; j < 7; j++) {
                if (matrix[i][j] > 0) {
                    countMatrix[i][j][0] = ++cnt;
                    for (int k = 1; k < cnt; k++) {
                        countMatrix[i][j - k][0] = cnt;
                    }
                } else {
                    cnt = 0;
                }
            }
        }
        for (int j = 0; j < 7; j++) {
            int cnt = 0;
            for (int i = 0; i < 7; i++) {
                if (matrix[i][j] > 0) {
                    countMatrix[i][j][1] = ++cnt;
                    for (int k = 1; k < cnt; k++) {
                        countMatrix[i - k][j][1] = cnt;
                    }
                } else {
                    cnt = 0;
                }
            }
        }

        boolean anyBomb = false;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (matrix[i][j] > 0 && (matrix[i][j] == countMatrix[i][j][0] || matrix[i][j] == countMatrix[i][j][1])) {
                    matrix[i][j] = 0;
                    anyBomb = true;
                }
            }
        }
        if (anyBomb) {
            matrix = clear(matrix);
            return bomb(matrix);
        } else {
            int cnt = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (matrix[i][j] > 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

    private int[][] clear(int[][] matrix) {
        int[][] next = new int[7][7];
        for (int j = 0; j < 7; j++) {
            int k = 6;
            for (int i = 6; i >= 0; i--) {
                if (matrix[i][j] > 0) {
                    next[k--][j] = matrix[i][j];
                }
            }
        }
        return next;
    }

    private int[][] drop(int[][] arr, int index, int ball) {
        int[][] drop = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                drop[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < 6; i++) {
            if (drop[i + 1][index] != 0) {
                drop[i][index] = ball;
                return drop;
            }
        }
        drop[6][index] = ball;
        return drop;
    }

    void main() throws IOException {
        //input
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ball = Integer.parseInt(br.readLine());

        int min = findMin(arr, ball);

        //output
        println(min);
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Main().main();
        bw.flush();
        bw.close();
        br.close();
    }

    void println(int n) throws IOException {
        println(String.valueOf(n));
    }

    void println(String str) throws IOException {
        bw.write(str + "\n");
    }

}
