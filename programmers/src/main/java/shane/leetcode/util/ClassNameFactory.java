package shane.leetcode.util;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClassNameFactory {

    public static final Set<Character> INVALID_CHARACTERS = new HashSet<>(Arrays.asList('-', '.')); // INVALID_CHARACTERS HAS TO BE SORTED ALL THE TIME
    public static final String LEETCODE_TITLE_REGEX = "[0-9]+\\..*";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        if (args == null || args.length == 0) {
            Transferable contents = clipboard.getContents(clipboard);
            if (contents != null) {
                try {
                    String clipboardString = ((String) contents.getTransferData(DataFlavor.stringFlavor)).trim();
                    if (clipboardString.matches(LEETCODE_TITLE_REGEX)) {
                        args = clipboardString.split(" ");
                    }
                } catch (UnsupportedFlavorException | IOException e) {
                    System.out.println("ClipBoard Data Type is invalid.");
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

        Thread.sleep(500); // on Linux if the program finishes too early clipboard data will be evaporated. So need some time

    }

    private static String[] getTitleInput() {
        System.out.println("Leetcode title: ");
        return SCANNER.nextLine().split(" ");
    }

    public static String getClassName(String[] args) {
        StringBuilder sb = new StringBuilder("Q");
        for (String s : args) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (INVALID_CHARACTERS.contains(c)) continue;
                if (i == 0 && Character.isLowerCase(c)) {
                    c -= 'a' - 'A';
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
