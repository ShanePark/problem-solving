package shane.boj.problems.b4659;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    void main() throws IOException {
        //input
        while (true) {
            String str = br.readLine();
            if ("end".equals(str)) {
                break;
            }
            boolean valid = valid(str);
            println("<" + str + "> is " + (valid ? "" : "not ") + "acceptable.");
        }

    }

    private boolean valid(String str) {
        char before = ' ';
        boolean hasVowel = false;
        int vowelCount = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (before == c && c != 'e' && c != 'o') {
                return false;
            }
            if (vowels.contains(c)) {
                vowelCount = vowelCount >= 0 ? vowelCount + 1 : 1;
                hasVowel = true;
            } else {
                vowelCount = vowelCount <= 0 ? vowelCount - 1 : -1;
            }
            if (Math.abs(vowelCount) == 3)
                return false;
            before = c;
        }
        return hasVowel;
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
