package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1191 ms Beats 16.57%
 * Memory 77.4 MB Beats 59.57%
 */
public class Q1146SnapshotArray2 {

    @Test
    void test() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        assertThat(snapshotArray.snap()).isEqualTo(0);
        snapshotArray.set(0, 6);
        assertThat(snapshotArray.get(0, 0)).isEqualTo(5);
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
            // if it is not fast enough, try binary search
            int answer = 0;
            for (int i = 0; i < snaps.size(); i++) {
                Snap snap = snaps.get(i);
                if (snap.snapId > snap_id) {
                    break;
                }
                answer = snap.value;
            }
            return answer;
        }
    }

    class Snap {
        int snapId;
        int value;

        public Snap(int snapId, int value) {
            this.snapId = snapId;
            this.value = value;
        }
    }

}
