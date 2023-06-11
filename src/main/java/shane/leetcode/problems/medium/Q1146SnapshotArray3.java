package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 58 ms Beats 95.43%
 * Memory 77.7 MB Beats 56.57%
 */
public class Q1146SnapshotArray3 {

    @Test
    void test() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        assertThat(snapshotArray.snap()).isEqualTo(0);
        snapshotArray.set(0, 6);
        assertThat(snapshotArray.get(0, 0)).isEqualTo(5);
    }

    @Test
    void test2() {
        SnapshotArray snapshotArray = new SnapshotArray(2);
        assertThat(snapshotArray.snap()).isEqualTo(0);
        assertThat(snapshotArray.get(1, 0)).isEqualTo(0);
        assertThat(snapshotArray.get(0, 0)).isEqualTo(0);
        snapshotArray.set(1, 8);
        assertThat(snapshotArray.get(1, 0)).isEqualTo(0);
        snapshotArray.set(0, 20);
        assertThat(snapshotArray.get(0, 0)).isEqualTo(0);
        snapshotArray.set(0, 7);
    }

    @Test
    void test3() {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.set(0, 4);
        snapshotArray.snap();
        assertThat(snapshotArray.get(0, 1));
        snapshotArray.set(0, 12);
        assertThat(snapshotArray.get(0, 1));
        snapshotArray.snap();
        assertThat(snapshotArray.get(0, 3));
    }

    @Test
    void test4() {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 4);
        snapshotArray.set(0, 16);
        snapshotArray.set(0, 13);
        snapshotArray.snap();
        assertThat(snapshotArray.get(0, 0)).isEqualTo(13);
        snapshotArray.snap();
    }

    class SnapshotArray {

        List<Snap>[] arr;
        int snapId = 0;

        public SnapshotArray(int length) {
            arr = new List[length];
            for (int i = 0; i < length; i++) {
                arr[i] = new ArrayList<>();
            }
        }

        public void set(int index, int val) {
            List<Snap> snaps = arr[index];
            int size = snaps.size();
            // if last snap was same snapId, remove it
            if (size > 0 && snaps.get(size - 1).snapId == snapId) {
                snaps.remove(size - 1);
            }
            snaps.add(new Snap(snapId, val));
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            List<Snap> snaps = arr[index];
            if (snaps.isEmpty() || snaps.get(0).snapId > snap_id)
                return 0;
            if (snaps.get(snaps.size() - 1).snapId <= snap_id) {
                return snaps.get(snaps.size() - 1).value;
            }
            int left = 0;
            int right = snaps.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (snaps.get(mid).snapId <= snap_id) {
                    left = mid + 1;
                    continue;
                }
                right = mid;
            }
            return snaps.get(left - 1).value;
        }
    }

    class Snap {
        int snapId;
        int value;

        public Snap(int snapId, int value) {
            this.snapId = snapId;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Snap{" +
                    "snapId=" + snapId +
                    ", value=" + value +
                    '}';
        }
    }

}
