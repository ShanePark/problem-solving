package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Not mine : https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/445769/merge-sort-CLEAR-simple-EXPLANATION-with-EXAMPLES-O(n-lg-n)
 */
public class Q315CountOfSmallerNumbersAfterSelf4 {

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

    private class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        final int LENGTH = nums.length;

        int[] answer = new int[LENGTH];
        Node[] arr = new Node[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            arr[i] = new Node(nums[i], i);
        }

        mergeSortAndCount(arr, 0, LENGTH - 1, answer);
        return Arrays.stream(answer).boxed().collect(Collectors.toList());
    }

    private void mergeSortAndCount(Node[] nodes, int left, int right, int[] answer) {
        if (left == right)
            return;

        int mid = (left + right) / 2;
        mergeSortAndCount(nodes, left, mid, answer);
        mergeSortAndCount(nodes, mid + 1, right, answer);

        List<Node> merged = new ArrayList<>();
        int leftPos = left;
        int rightPos = mid + 1;
        int smaller = 0;

        while (leftPos < mid + 1 && rightPos <= right) {
            if (nodes[leftPos].val > nodes[rightPos].val) {
                merged.add(nodes[rightPos++]);
                smaller++;
            } else {
                answer[nodes[leftPos].index] += smaller;
                merged.add(nodes[leftPos++]);
            }
        }
        while (leftPos < mid + 1) {
            answer[nodes[leftPos].index] += smaller;
            merged.add(nodes[leftPos++]);
        }
        while (rightPos <= right) {
            merged.add(nodes[rightPos++]);
        }

        for (Node m : merged) {
            nodes[left++] = m;
        }
    }
}
