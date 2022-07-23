package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q315CountOfSmallerNumbersAfterSelf3 {

    /**
     * 537 ms TLE
     */
    @Test
    public void test2() {
        int[] arr = new int[100000];
        assertThat(countSmaller(arr)).hasSize(100000);
    }

    @Test
    public void test() {
        assertThat(countSmaller(new int[]{2, 0, 1})).containsExactly(2, 0, 0);
        assertThat(countSmaller(new int[]{5, 2, 6, 1})).containsExactly(2, 1, 1, 0);
        assertThat(countSmaller(new int[]{-1, -1})).containsExactly(0, 0);
        assertThat(countSmaller(new int[]{-1, 0})).containsExactly(0, 0);
        assertThat(countSmaller(new int[]{-1})).containsExactly(0);
    }

    @Test
    public void test3() {
        assertThat(countSmaller(new int[]{2, 1, 1, 2})).containsExactly(2, 0, 0, 0);
        assertThat(countSmaller(new int[]{2, 1, 1, 1})).containsExactly(3, 0, 0, 0);
        assertThat(countSmaller(new int[]{2, 1, 1, 3})).containsExactly(2, 0, 0, 0);
        assertThat(countSmaller(new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41}))
                .containsExactly(10, 27, 10, 35, 12, 22, 28, 8, 19, 2, 12, 2, 9, 6, 12, 5, 17, 9, 19, 12, 14, 6, 12, 5, 12, 3, 0, 10, 0, 7, 8, 4, 0, 0, 4, 3, 2, 0, 1, 0);
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Node head = new Node(nums[nums.length - 1]);
        answer.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int n = nums[i];
            int val = getVal(n, head, 0);
            answer.add(0, val);
        }
        return answer;
    }

    private int getVal(int n, Node head, int smaller) {
        int val = head.val;
        if (n == val) {
            head.cnt++;
            return smaller + head.smaller;
        } else if (n < val) {
            head.smaller++;
            if (head.left == null) {
                head.left = new Node(n);
            } else {
                return getVal(n, head.left, smaller);
            }
        } else {
            smaller += head.smaller + head.cnt;
            if (head.right == null) {
                head.right = new Node(n);
            } else {
                return getVal(n, head.right, smaller);
            }
        }
        return smaller;
    }

    private class Node {
        int val;
        int smaller = 0;
        int cnt = 1;

        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", smaller=" + smaller +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
