package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1352ProductOfTheLastKNumbers2 {

    @Test
    public void test() {
        ProductOfNumbers pn = new ProductOfNumbers();
        pn.add(3);
        pn.add(0);
        pn.add(2);
        pn.add(5);
        pn.add(4);
        assertThat(pn.getProduct(2)).isEqualTo(20);
        assertThat(pn.getProduct(3)).isEqualTo(40);
        assertThat(pn.getProduct(4)).isEqualTo(0);
        pn.add(8);
        assertThat(pn.getProduct(2)).isEqualTo(32);
    }

    @Test
    public void test2() {
        ProductOfNumbers pn = new ProductOfNumbers();
        pn.add(1);
        assertThat(pn.getProduct(1)).isEqualTo(1);
        assertThat(pn.getProduct(1)).isEqualTo(1);
        assertThat(pn.getProduct(1)).isEqualTo(1);
        pn.add(7);
        pn.add(6);
        pn.add(7);
    }

    @Test
    public void test3() {
        ProductOfNumbers pn = new ProductOfNumbers();
        pn.add(7);
        assertThat(pn.getProduct(1)).isEqualTo(7);
        pn.add(5);
        pn.add(0);
        pn.add(4);
        assertThat(pn.getProduct(4)).isEqualTo(0);
        assertThat(pn.getProduct(3)).isEqualTo(0);
        assertThat(pn.getProduct(1)).isEqualTo(4);
        pn.add(9);
    }

    @Test
    public void test4() {
        ProductOfNumbers pn = new ProductOfNumbers();
        pn.add(67);
        pn.add(46);
        pn.add(86);
        assertThat(pn.getProduct(3)).isEqualTo(265052);
        assertThat(pn.getProduct(2)).isEqualTo(3956);
        assertThat(pn.getProduct(3)).isEqualTo(265052);
        pn.add(63);
        pn.add(0);
        pn.add(83);
        assertThat(pn.getProduct(6)).isEqualTo(0);
        pn.add(52);
        pn.add(81);
        assertThat(pn.getProduct(5)).isEqualTo(0);
        pn.add(98);
        pn.add(0);
    }

    class ProductOfNumbers {
        private final List<Integer> list = new ArrayList<>();

        public void add(int num) {
            if (num == 0) {
                list.clear();
                return;
            }
            if (list.isEmpty()) {
                list.add(num);
                return;
            }
            list.add(list.get(list.size() - 1) * num);
        }

        public int getProduct(int k) {
            if (list.size() < k)
                return 0;
            if (list.size() == k)
                return list.get(list.size() - 1);
            return list.get(list.size() - 1) / list.get(list.size() - k - 1);
        }
    }

}


