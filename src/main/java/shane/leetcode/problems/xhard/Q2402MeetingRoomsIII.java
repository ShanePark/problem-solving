package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 156 ms Beats 7.95% of users with Java
 */
public class Q2402MeetingRoomsIII {

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
        PriorityQueue<Room> emptyRooms = new PriorityQueue<>(Comparator.comparingInt(r -> r.index));
        for (int i = 0; i < n; i++) {
            emptyRooms.offer(new Room(i));
        }
        PriorityQueue<Room> occupiedRooms = new PriorityQueue<>(Comparator.comparingLong(r -> r.endTime));

        int[] meetingCnt = new int[n];
        long time = 0;
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));

        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            int meetingStart = meeting[0];
            time = Math.max(time, meetingStart);

            // process occupied rooms
            while (!occupiedRooms.isEmpty()) {
                Room poll = occupiedRooms.poll();
                if (poll.checkEnd(time)) {
                    emptyRooms.offer(poll);
                    continue;
                }
                occupiedRooms.offer(poll);
                break;
            }

            if (emptyRooms.isEmpty()) {
                time = occupiedRooms.peek().endTime;
                i--;
                continue;
            }

            // start meeting
            Room room = emptyRooms.poll();
            room.startMeeting(time, meeting);
            meetingCnt[room.index]++;
            occupiedRooms.offer(room);
        }

        int maxIndex = 0;
        for (int i = 0; i < meetingCnt.length; i++) {
            if (meetingCnt[maxIndex] < meetingCnt[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static class Room {
        int index;
        Long endTime = null;

        public Room(int i) {
            this.index = i;
        }

        public boolean checkEnd(long time) {
            if (this.endTime <= time) {
                this.endTime = null;
                return true;
            }
            return false;
        }

        public void startMeeting(long curTime, int[] meeting) {
            int duration = meeting[1] - meeting[0];
            this.endTime = curTime + duration;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "index=" + index +
                    ", endTime=" + endTime +
                    '}';
        }
    }

}
