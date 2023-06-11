package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Memory Limit Exceeded
 */
public class Q1146SnapshotArray {

    @Test
    void test() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        assertThat(snapshotArray.snap()).isEqualTo(0);
        snapshotArray.set(0, 6);
        assertThat(snapshotArray.get(0, 0)).isEqualTo(5);
    }

    class SnapshotArray {

        int[] arr;
        int snapId = 0;
        List<int[]> snaps = new ArrayList<>();

        public SnapshotArray(int length) {
            arr = new int[length];
        }

        public void set(int index, int val) {
            arr[index] = val;
        }

        public int snap() {
            snaps.add(Arrays.copyOf(arr, arr.length));
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return snaps.get(snap_id)[index];
        }
    }

}
