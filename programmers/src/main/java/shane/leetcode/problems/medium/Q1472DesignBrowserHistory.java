package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1472DesignBrowserHistory {

    @Test
    public void test() {
        final String LEETCODE = "leetcode.com";
        final String GOOGLE = "google.com";
        final String FACEBOOK = "facebook.com";
        final String YOUTUBE = "youtube.com";
        final String LINKEDIN = "linkedin.com";

        BrowserHistory bh = new BrowserHistory(LEETCODE);
        bh.visit(GOOGLE);
        bh.visit(FACEBOOK);
        bh.visit(YOUTUBE);
        assertThat(bh.back(1)).isEqualTo(FACEBOOK);
        assertThat(bh.back(1)).isEqualTo(GOOGLE);
        assertThat(bh.forward(1)).isEqualTo(FACEBOOK);
        bh.visit(LINKEDIN);
        assertThat(bh.forward(2)).isEqualTo(LINKEDIN);
        assertThat(bh.back(2)).isEqualTo(GOOGLE);
        assertThat(bh.back(7)).isEqualTo(LEETCODE);
    }

    @Test
    public void test2() {

        BrowserHistory bh = new BrowserHistory("icpbj.com");
        assertThat(bh.back(1)).isEqualTo("icpbj.com");
        assertThat(bh.back(10)).isEqualTo("icpbj.com");
        bh.visit("xbepk.com");
        assertThat(bh.forward(8)).isEqualTo("xbepk.com");
        bh.visit("kls.com");
        bh.visit("dlkwxpf.com");
        bh.visit("pnep.com");
        assertThat(bh.back(9)).isEqualTo("icpbj.com");
        bh.visit("rmis.com");
        bh.visit("bxf.com");
        bh.visit("dz.com");
        assertThat(bh.back(2)).isEqualTo("rmis.com");
        bh.visit("acuqsax.com");
        bh.visit("dcvo.com");
        bh.visit("ijbg.com");
        bh.visit("nlott.com");
        assertThat(bh.back(7)).isEqualTo("icpbj.com");
        bh.visit("dd.com");
        bh.visit("vssnq.com");
        bh.visit("teur.com");
        bh.visit("pn.com");
        bh.visit("szi.com");
        bh.visit("brhldg.com");
        bh.visit("yulyoqv.com");
        assertThat(bh.back(4)).isEqualTo("teur.com");
        assertThat(bh.forward(10)).isEqualTo("yulyoqv.com");
        assertThat(bh.back(8)).isEqualTo("icpbj.com");
        assertThat(bh.forward(5)).isEqualTo("szi.com");
        bh.visit("av.com");
        assertThat(bh.back(3)).isEqualTo("teur.com");
        bh.visit("okr.com");
        bh.visit("meli.com");
    }

    class BrowserHistory {

        Stack<String> back = new Stack<>();
        Stack<String> forward = new Stack<>();
        String current;

        public BrowserHistory(String homepage) {
            current = homepage;
        }

        public void visit(String url) {
            back.push(current);
            current = url;
            forward.clear();
        }

        public String back(int steps) {

            int size = back.size();
            for (int i = 0; i < Math.min(size, steps); i++) {
                forward.push(current);
                current = back.pop();
            }
            return current;
        }

        public String forward(int steps) {
            int size = forward.size();
            for (int i = 0; i < Math.min(size, steps); i++) {
                back.push(current);
                current = forward.pop();
            }
            return current;
        }
    }

}
