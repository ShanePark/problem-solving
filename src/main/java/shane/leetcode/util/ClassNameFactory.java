package shane.leetcode.util;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClassNameFactory {

    public final String LEETCODE_TITLE_REGEX = "[0-9]+\\..*";
    protected final Set<Character> INVALID_CHARACTERS = new HashSet<>(Arrays.asList(
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '?', '/', ' ', '`'
    ));

    public static void main(String[] args) throws InterruptedException {
        ClassNameFactory classNameFactory = new ClassNameFactory();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        String title = null;

        if (args != null && args.length != 0) {
            title = String.join(" ", args);
        }

        if (title == null) {
            Transferable contents = clipboard.getContents(clipboard);
            if (contents != null) {
                try {
                    title = ((String) contents.getTransferData(DataFlavor.stringFlavor)).trim();
                    if (!title.matches(classNameFactory.LEETCODE_TITLE_REGEX)) {
                        title = null;
                    }
                } catch (UnsupportedFlavorException | IOException e) {
                    System.out.println("ClipBoard Data Type is invalid.");
                }
            }
        }

        if (title == null) {
            args = classNameFactory.getTitleInput();
            title = String.join(" ", args);
        }

        String className = classNameFactory.getClassName(title);
        System.out.println("Class name : " + className);
        System.out.println("class name has been copied to your Clipboard!");

        StringSelection stringSelection = new StringSelection(className);
        clipboard.setContents(stringSelection, null);

        Thread.sleep(500); // on Linux if the program finishes too early clipboard data will be evaporated. So need some time
    }

    private String[] getTitleInput() {
        System.out.println("Leetcode title: ");
        return new Scanner(System.in).nextLine().split(" ");
    }

    public String getClassName(String str) {
        int firstDotIndex = str.indexOf(".");
        String number = str.substring(0, firstDotIndex);
        String title = str.substring(firstDotIndex + 1).trim();

        StringBuilder sb = new StringBuilder("Q" + number);
        if (Character.isDigit(title.charAt(0))) {
            sb.append("_");
        }
        for (String s : title.split(" ")) {
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
