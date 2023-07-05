package shane.leetcode.util;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class ClassNameFactory {

    public final String LEETCODE_TITLE_REGEX = "[0-9]+\\..*";
    private final Set<Character> INVALID_CHARACTERS;

    public ClassNameFactory() {
        List<Character> invalidCharacters = Arrays.asList(
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '?', '/', ' '
        );
        this.INVALID_CHARACTERS = new HashSet<>(invalidCharacters);
    }

    public static void main(String[] args) throws InterruptedException {
        ClassNameFactory classNameFactory = new ClassNameFactory();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String clipboardString = null;

        if (args == null || args.length == 0) {
            Transferable contents = clipboard.getContents(clipboard);
            if (contents != null) {
                try {
                    clipboardString = ((String) contents.getTransferData(DataFlavor.stringFlavor)).trim();
                    if (!clipboardString.matches(classNameFactory.LEETCODE_TITLE_REGEX)) {
                        clipboardString = null;
                    }
                } catch (UnsupportedFlavorException | IOException e) {
                    System.out.println("ClipBoard Data Type is invalid.");
                }
            }
        }

        if (clipboardString == null && (args == null || args.length == 0)) {
            args = classNameFactory.getTitleInput();
        }

        String className;
        if (clipboardString != null) {
            className = classNameFactory.getClassName(clipboardString);
        } else {
            className = classNameFactory.getClassName(args);
        }

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
        return getClassName(str.split(" "));
    }

    public String getClassName(String[] args) {
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
