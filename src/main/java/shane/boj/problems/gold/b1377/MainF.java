package shane.boj.problems.gold.b1377;
/**
 * don't forget to Copy from import to the EOF
 * try not to copy first line "package ..."
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;

/**
 * TLE
 */
public class MainF {

    void main() throws IOException {
        //input
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean changed;
        for (int i = 0; i <= size; i++) {
            changed = false;
            for (int j = 0; j <= size - 2; j++) {
                if (arr[j] > arr[j + 1]) {
                    changed = true;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (changed == false) {
                println(i + 1);
                break;
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new MainF().main();
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
