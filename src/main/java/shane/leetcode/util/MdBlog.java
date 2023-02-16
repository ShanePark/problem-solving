package shane.leetcode.util;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class MdBlog {
    static final String MDBLOG = "https://raw.githubusercontent.com/ShanePark/mdblog/main/";

    public static void main(String[] args) throws InterruptedException {

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        StringSelection stringSelection = new StringSelection(MDBLOG);
        clipboard.setContents(stringSelection, null);
        System.out.println(MDBLOG);
        Thread.sleep(200); // on Linux if the program finishes too early clipboard data will be evaporated. So need some time
    }
}
