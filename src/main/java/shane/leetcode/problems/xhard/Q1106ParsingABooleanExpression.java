package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime12msBeats57.93%
 */
public class Q1106ParsingABooleanExpression {

    @Test
    public void test() {
        assertThat(parseBoolExpr("&(|(f))")).isFalse();
        assertThat(parseBoolExpr("|(f,f,f,t)")).isTrue();
        assertThat(parseBoolExpr("!(&(f,t))")).isTrue();
    }

    public boolean parseBoolExpr(String expression) {
        int length = expression.length();
        char c = expression.charAt(0);
        if (c == 't')
            return true;
        if (c == 'f')
            return false;
        String substring = expression.substring(2, length - 1);
        if (c == '!') {
            return !parseBoolExpr(substring);
        }
        List<Boolean> splits = split(substring);
        if (c == '&') {
            for (boolean split : splits) {
                if (!split)
                    return false;
            }
            return true;
        }
        for (boolean split : splits) {
            if (split)
                return true;
        }
        return false;
    }

    private List<Boolean> split(String substring) {
        List<Boolean> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int openParentheses = 0;
        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            sb.append(c);
            if (c == '(') {
                openParentheses++;
            }
            if (c == ')')
                openParentheses--;
            if (c == ',' && openParentheses == 0) {
                sb.deleteCharAt(sb.length() - 1);
                list.add(parseBoolExpr(sb.toString()));
                sb = new StringBuilder();
            }
        }
        list.add(parseBoolExpr(sb.toString()));
        return list;
    }

}
