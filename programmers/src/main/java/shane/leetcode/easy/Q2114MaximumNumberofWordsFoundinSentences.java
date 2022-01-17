package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

public class Q2114MaximumNumberofWordsFoundinSentences {

    public static void main(String[] args) {
        Assertions.assertEquals(6, mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}));
        Assertions.assertEquals(3, mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"}));
    }

    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            max = Math.max(max, sentence.split(" ").length);
        }
        return max;
    }

}
