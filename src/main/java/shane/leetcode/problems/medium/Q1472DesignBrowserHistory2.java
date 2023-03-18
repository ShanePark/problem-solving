package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 110 ms Beats 20.88%
 * Memory 50.1 MB Beats 84.19%
 */
public class Q1472DesignBrowserHistory2 {

    @Test
    public void test() {
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        assertThat(bh.back(1)).isEqualTo("facebook.com");
        assertThat(bh.back(1)).isEqualTo("google.com");
        assertThat(bh.forward(1)).isEqualTo("facebook.com");
        bh.visit("linkedin.com");
        assertThat(bh.forward(2)).isEqualTo("linkedin.com");
        assertThat(bh.back(2)).isEqualTo("google.com");
        assertThat(bh.back(7)).isEqualTo("leetcode.com");
    }

    class BrowserHistory {

        Stack<String> back = new Stack<>();
        Stack<String> forward = new Stack<>();
        String current;

        public BrowserHistory(String homepage) {
            this.current = homepage;
        }

        public void visit(String url) {
            back.push(current);
            current = url;
            forward.clear();
        }

        public String back(int steps) {
            for (int i = 0; i < steps && !back.isEmpty(); i++) {
                forward.push(current);
                current = back.pop();
            }
            return current;
        }

        public String forward(int steps) {
            for (int i = 0; i < steps && !forward.isEmpty(); i++) {
                back.push(current);
                current = forward.pop();
            }
            return current;
        }
    }

}
