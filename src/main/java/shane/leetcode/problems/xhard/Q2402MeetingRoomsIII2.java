package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 100ms
 * Beats10.57%
 */
public class Q2402MeetingRoomsIII2 {

    @Test
    public void test() {
        assertThat(mostBooked(2, Ps.intArray("[[0,10],[1,5],[2,7],[3,4]]"))).isEqualTo(0);
        assertThat(mostBooked(3, Ps.intArray("[[1,20],[2,10],[3,5],[4,9],[6,8]]"))).isEqualTo(1);
    }

    @Test
    public void test2() {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= 80000; i++) {
            list.add(new int[]{i, i + 300000});
        }
        list.add(new int[]{80001, 300000});
        for (int i = 2; i <= 11; i++) {
            list.add(new int[]{80000 + i, 80000 + i + 1});
        }
        int[][] arr = list.toArray(new int[][]{});
        assertThat(mostBooked(10, arr)).isEqualTo(1);
    }

    public int mostBooked(int n, int[][] meetings) {
        Map<Integer, Integer> heldCnt = new HashMap<>();
        PriorityQueue<Integer> emptyRooms = IntStream.range(0, n).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>(Comparator.comparingLong(o -> o[0])); // endTime, roomNumber, sort by endTime
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        long curTime = 0;
        for (int[] meeting : meetings) {
            curTime = Math.max(curTime, meeting[0]);
            reArrangeRooms(occupiedRooms, curTime, emptyRooms);
            if (emptyRooms.isEmpty()) {
                curTime = occupiedRooms.peek()[0];
                reArrangeRooms(occupiedRooms, curTime, emptyRooms);
            }

            int room = emptyRooms.poll();
            heldCnt.merge(room, 1, Integer::sum);
            long endTime = curTime + (meeting[1] - meeting[0]);
            occupiedRooms.offer(new long[]{endTime, room});
        }

        return heldCnt.entrySet()
                .stream().min((e1, e2) -> {
                    if ((int) e1.getValue() == e2.getValue())
                        return e1.getKey() - e2.getKey();
                    return e2.getValue() - e1.getValue();
                })
                .get()
                .getKey();
    }

    private static void reArrangeRooms(PriorityQueue<long[]> occupiedRooms, long curTime, PriorityQueue<Integer> emptyRooms) {
        while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= curTime) {
            long[] finish = occupiedRooms.poll();
            emptyRooms.offer((int) finish[1]);
        }
    }

}
