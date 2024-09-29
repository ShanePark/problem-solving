package shane.leetcode.util;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassNameFactoryTest {

    ClassNameFactory classNameFactory = new ClassNameFactory();

    @Test
    void regexText() {
        assertThat(Pattern.matches(classNameFactory.LEETCODE_TITLE_REGEX, "338. Counting Bits")).isTrue();
        assertThat(Pattern.matches(classNameFactory.LEETCODE_TITLE_REGEX, "338")).isFalse();
    }

    @Test
    void test() {
        final String[] args = "1315. Sum of Nodes with Even-Valued Grandparent".split(" ");

        StringBuilder sb = new StringBuilder("Q");
        for (String s : args) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (classNameFactory.INVALID_CHARACTERS.contains(c)) continue;
                if (i == 0 && Character.isLowerCase(c)) {
                    c -= 'a' - 'A';
                }
                sb.append(c);
            }
        }
        String className = sb.toString();
        assertThat(className).isEqualTo("Q1315SumOfNodesWithEvenValuedGrandparent");
        System.out.println("Class name : " + className);
        System.out.println("class name has been copied to your Clipboard!");

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(className);
        clipboard.setContents(stringSelection, null);
    }

    @Test
    public void startsWithNumber() {
        assertThat(classNameFactory.getClassName("456. 132 Pattern"))
                .isEqualTo("Q456_132Pattern");
    }

    @Test
    public void forbiddenWords() {
        assertThat(classNameFactory.getClassName("2124. Check if All A's Appears Before All B's"))
                .isEqualTo("Q2124CheckIfAllAsAppearsBeforeAllBs");
        assertThat(classNameFactory.getClassName("208. Implement Trie (Prefix Tree)"))
                .isEqualTo("Q208ImplementTriePrefixTree");
        assertThat(classNameFactory.getClassName("1493. Longest Subarray of 1's After Deleting One Element"))
                .isEqualTo("Q1493LongestSubarrayOf1sAfterDeletingOneElement");
        assertThat(classNameFactory.getClassName("432. All O`one Data Structure"))
                .isEqualTo("Q432AllOoneDataStructure");
    }

}
