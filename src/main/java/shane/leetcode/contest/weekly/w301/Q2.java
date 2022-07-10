package shane.leetcode.contest.weekly.w301;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);
        assertThat(set.popSmallest()).isEqualTo(1);
        assertThat(set.popSmallest()).isEqualTo(2);
        assertThat(set.popSmallest()).isEqualTo(3);
        set.addBack(1);
        assertThat(set.popSmallest()).isEqualTo(1);
        assertThat(set.popSmallest()).isEqualTo(4);
        assertThat(set.popSmallest()).isEqualTo(5);
    }

    @Test
    public void test2() {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        assertThat(set.popSmallest()).isEqualTo(1);
        set.addBack(1);
        assertThat(set.popSmallest()).isEqualTo(1);
        assertThat(set.popSmallest()).isEqualTo(2);
        assertThat(set.popSmallest()).isEqualTo(3);
        set.addBack(2);
        set.addBack(3);
        assertThat(set.popSmallest()).isEqualTo(2);
        assertThat(set.popSmallest()).isEqualTo(3);
    }

    class SmallestInfiniteSet {

        Set<Integer> set;
        int index = 1;

        public SmallestInfiniteSet() {
            set = new HashSet<>();
        }

        public int popSmallest() {
            while (set.contains(index)) {
                index++;
            }
            set.add(index);
            return index++;
        }

        public void addBack(int num) {
            if (set.contains(num)) {
                set.remove(num);
                if(index > num)
                    index = num;
            }
        }
    }

}
