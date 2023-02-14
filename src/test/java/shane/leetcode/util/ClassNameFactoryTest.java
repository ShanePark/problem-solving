package shane.leetcode.util;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static shane.leetcode.util.ClassNameFactory.getClassName;

public class ClassNameFactoryTest {

    @Test
    void regexText() {
        assertThat(Pattern.matches(ClassNameFactory.LEETCODE_TITLE_REGEX, "338. Counting Bits")).isTrue();
        assertThat(Pattern.matches(ClassNameFactory.LEETCODE_TITLE_REGEX, "338")).isFalse();
    }

    @Test
    void test() {
        final String[] args = "1315. Sum of Nodes with Even-Valued Grandparent".split(" ");

        String className = getClassName(args);
        assertThat(className).isEqualTo("Q1315SumOfNodesWithEvenValuedGrandparent");
        System.out.println("Class name : " + className);
        System.out.println("class name has been copied to your Clipboard!");

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(className);
        clipboard.setContents(stringSelection, null);
    }

    @Test
    public void forbiddenWords() {
        assertThat(getClassName("2124. Check if All A's Appears Before All B's".split(" ")))
                .isEqualTo("Q2124CheckIfAllAsAppearsBeforeAllBs");
    }

}
