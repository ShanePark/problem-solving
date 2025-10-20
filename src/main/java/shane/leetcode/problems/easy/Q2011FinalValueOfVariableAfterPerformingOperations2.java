package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

/**
 * Runtime
0ms
Beats100.00%

 */
public class Q2011FinalValueOfVariableAfterPerformingOperations2 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int answer = 0;
        for (String operation : operations) {
            char c = operation.charAt(1);
            if(c == '+'){
                answer++;
                continue;
            }
            answer--;
        }
        return answer;
    }

}
