package shane.boj.problems.silver.b14469_2;
/**
 * don't forget to Copy from import to the EOF
 * try not to copy first line "package ..."
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    void main() throws IOException {
        //input

        final int LENGTH = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < LENGTH; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.add(new int[]{arrive, time});
        }

        list.sort(Comparator.comparingInt(arr -> arr[0]));

        //logic
        int time = 0;
        for (int[] ints : list) {
            time = Math.max(time, ints[0]);
            time += ints[1];
        }

        //output
        println(time);
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
