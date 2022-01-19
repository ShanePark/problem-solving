package shane.leetcode.easy;

import org.junit.jupiter.api.Assertions;

public class Q2011FinalValueOfVariableAfterPerformingOperations {

    public static void main(String[] args) {
        Assertions.assertEquals(3, finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if (operation.indexOf("+") >= 0) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

}
