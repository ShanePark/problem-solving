package shane.boj;
/**
 * Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //input
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        String first = st.nextToken();
        String second = st.nextToken();

        //logic
        int answer = Integer.parseInt(first) + Integer.parseInt(second);

        //output
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
