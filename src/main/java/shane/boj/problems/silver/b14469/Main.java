package shane.boj.problems.silver.b14469;
/**
 * don't forget to Copy from import to the EOF
 * try not to copy first line "package ..."
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    void main() throws IOException {
        //input
        String line = br.readLine();
        int length = Integer.parseInt(line);

        class Cow {
            int arrive;
            int time;

            public Cow(int arrive, int time) {
                this.arrive = arrive;
                this.time = time;
            }
        }
        PriorityQueue<Cow> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.arrive));

        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            pq.offer(new Cow(arrive, time));
        }

        //logic
        int time = 0;
        while (!pq.isEmpty()) {
            Cow cow = pq.poll();
            time = Math.max(time, cow.arrive);
            time += cow.time;
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
