package shane.leetcode.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.Scanner;

public class ClassNameFactory {

    private static Character[] invalid = {'-', '.'};

    public static void main(String[] args) {
        System.out.println("Leetcode title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String className = getClassName(title.split(" "));

        System.out.println("Class name : " + className);
        System.out.println("class name has been copied to your Clipboard!");

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(className);
        clipboard.setContents(stringSelection, null);

    }

    @Test
    void test() {
        Arrays.sort(invalid);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final String[] args = "1315. Sum of Nodes with Even-Valued Grandparent".split(" ");

        String className = getClassName(args);
        System.out.println("Class name : " + className);
        System.out.println("class name has been copied to your Clipboard!");

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(className);
        clipboard.setContents(stringSelection, null);

        stopWatch.stop();
        System.out.println("stopWatch = " + stopWatch.getTotalTimeMillis() + "ms");

        return;
    }

    public static String getClassName(String[] args) {
        StringBuffer sb = new StringBuffer("Q");
        for (String s : args) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i == 0 && 'a' <= c && c <= 'z') {
                    c -= 'a' - 'A';
                }
                if (Arrays.binarySearch(invalid, c) < 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
