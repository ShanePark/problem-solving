package shane.boj.problems.silver.b2667;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    void main() throws IOException {
        //input
        int length = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            String line = br.readLine();
            arr[i] = new boolean[length];
            for (int j = 0; j < length; j++) {
                arr[i][j] = line.charAt(j) == '1';
            }
        }

        boolean[][] visited = new boolean[length][length];

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (arr[i][j]) {
                        int cur = ++count;
                        travel(i, j, length, arr, visited, map, cur);
                    }
                }
            }
        }

        List<Integer> values = map.values().stream().sorted().collect(Collectors.toList());

        //output
        println(count);
        for (Integer value : values) {
            println(value);
        }
    }

    private void travel(int i, int j, int length, boolean[][] arr, boolean[][] visited, Map<Integer, Integer> map, int cur) {
        visited[i][j] = true;
        map.merge(cur, 1, Integer::sum);
        // up
        if (0 < i && !visited[i - 1][j] && arr[i - 1][j]) {
            travel(i - 1, j, length, arr, visited, map, cur);
        }
        // down
        if (i < length - 1 && !visited[i + 1][j] && arr[i + 1][j]) {
            travel(i + 1, j, length, arr, visited, map, cur);
        }
        // left
        if (0 < j && !visited[i][j - 1] && arr[i][j - 1]) {
            travel(i, j - 1, length, arr, visited, map, cur);
        }
        // right
        if (j < length - 1 && !visited[i][j + 1] && arr[i][j + 1]) {
            travel(i, j + 1, length, arr, visited, map, cur);
        }
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
