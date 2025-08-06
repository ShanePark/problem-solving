package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3479FruitsIntoBasketsIII {

    @Test
    public void test() {
        assertThat(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4})).isEqualTo(1);
        assertThat(numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7})).isEqualTo(0);
    }

    int[] segTree;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        segTree = new int[4 * fruits.length];
        constructTree(baskets, 0, fruits.length - 1, 1);
        int ans = 0;
        for (int fruit : fruits) {
            int pos = search(1, 0, fruits.length - 1, fruit);
            if (pos == -1)
                ans++;
        }
        return ans;

    }

    void constructTree(int[] basket, int st, int end, int n) {
        if (st == end) {
            segTree[n] = basket[st];
            return;
        }
        int mid = (st + end) / 2;
        constructTree(basket, st, mid, 2 * n);
        constructTree(basket, mid + 1, end, 2 * n + 1);
        segTree[n] = Math.max(segTree[2 * n], segTree[2 * n + 1]);
    }

    int search(int n, int st, int end, int k) {
        if (segTree[n] < k) return -1;
        if (st == end) {
            segTree[n] = -1;
            return st;
        }
        int mid = (st + end) / 2;
        int pos;
        if (segTree[2 * n] >= k) {
            pos = search(2 * n, st, mid, k);
        } else {
            pos = search(2 * n + 1, mid + 1, end, k);
        }
        segTree[n] = Math.max(segTree[2 * n], segTree[2 * n + 1]);
        return pos;
    }

}
