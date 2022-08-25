package shane.boj.problems.silver.b20921;
/**
 * don't forget to Copy from import to the EOF
 * try not to copy first line "package ..."
 * * * * * * * * * * * * * * * * *
 */

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {

    @Test
    public void test() {
        assertThat(solution(5, 10)).containsExactly(5, 4, 3, 2, 1);
        assertThat(solution(5, 7)).containsExactly(5, 4, 1, 2, 3);
        assertThat(solution(4, 2)).containsExactly(1, 4, 2, 3);
        assertThat(solution(3, 0)).containsExactly(1, 2, 3);
    }

    private List<Integer> solution(int N, int K) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int place = 0;
        while (K > 0) {
            int last = list.remove(N - 1);
            int move = Math.min(K, N - 1 - place);
            int newIndex = N - move - 1;
            place = newIndex + 1;
            list.add(newIndex, last);
            K -= move;
        }

        return list;

    }

    void main() throws IOException {
        //input
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        //logic
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> solution = solution(N, K);

        StringBuilder sb = new StringBuilder();
        for (Integer i : solution) {
            sb.append(i + " ");
        }

        sb.deleteCharAt(sb.length() - 1);

        //output
        println(sb.toString());
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
