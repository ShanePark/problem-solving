package shane.boj.problems.silver.b1149;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    void main() throws IOException {
        //input
        int cnt = Integer.parseInt(br.readLine());
        int[][] houses = new int[cnt][3];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int price = Integer.parseInt(st.nextToken());
                houses[i][j] = price;
            }
        }

        //logic
        for (int i = 1; i < cnt; i++) {
            houses[i][0] += Math.min(houses[i - 1][1], houses[i - 1][2]);
            houses[i][1] += Math.min(houses[i - 1][0], houses[i - 1][2]);
            houses[i][2] += Math.min(houses[i - 1][0], houses[i - 1][1]);
        }

        //output
        int answer = Math.min(houses[cnt - 1][0], Math.min(houses[cnt - 1][1], houses[cnt - 1][2]));
        println(answer);
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
