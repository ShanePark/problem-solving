package shane.leetcode.util;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ClassNameFactory {

    public static Character[] invalid = {'-', '.'};
    public static String regex = "[0-9]+\\..*";

    public static void main(String[] args) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (args == null || args.length == 0) {
            Transferable contents = clipboard.getContents(clipboard);
            if (contents != null) {
                try {
                    String pasteString = ((String) contents.getTransferData(DataFlavor.stringFlavor)).trim();
                    if (pasteString.matches(regex)) {
                        args = pasteString.split(" ");
                    }
                } catch (UnsupportedFlavorException | IOException e) {
                    System.out.println("ClipBoard Data is invalid.");
                }
            }
        }

        if (args == null || args.length == 0) {
            args = getTitleInput();
        }

        String className = getClassName(args);

        System.out.println("Class name : " + className);
        System.out.println("class name has been copied to your Clipboard!");

        StringSelection stringSelection = new StringSelection(className);
        clipboard.setContents(stringSelection, null);

    }

    private static String[] getTitleInput() {
        System.out.println("Leetcode title: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(" ");
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
