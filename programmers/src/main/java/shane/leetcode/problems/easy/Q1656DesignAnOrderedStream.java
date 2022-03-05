package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1656DesignAnOrderedStream {

    @Test
    void test() {
        OrderedStream obj = new OrderedStream(5);
        Assertions.assertThat(obj.insert(3, "ccccc")).containsExactly();
        Assertions.assertThat(obj.insert(1, "aaaaa")).containsExactly("aaaaa");
        Assertions.assertThat(obj.insert(2, "bbbbb")).containsExactly("bbbbb", "ccccc");
        Assertions.assertThat(obj.insert(5, "eeeee")).containsExactly();
        Assertions.assertThat(obj.insert(4, "ddddd")).containsExactly("ddddd", "eeeee");
    }

    class OrderedStream {

        String[] arr;
        int ptr = 0;

        public OrderedStream(int n) {
            arr = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            arr[idKey - 1] = value;

            if (ptr < idKey - 1)
                return Collections.emptyList();

            List<String> list = new ArrayList<>();
            while (ptr < arr.length && arr[ptr] != null) {
                list.add(arr[ptr++]);
            }
            return list;

        }
    }

}
