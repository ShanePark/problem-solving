package shane.boj;
/**
 * don't forget to Copy from import to the EOF
 * try not to copy first line "package ..."
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    void main() throws IOException {
        //input
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        //logic
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int answer = first + second;

        //output
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
