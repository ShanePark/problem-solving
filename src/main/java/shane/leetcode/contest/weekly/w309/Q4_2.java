package shane.leetcode.contest.weekly.w309;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 209 ms, faster than 12.50% of Java online submissions for Meeting Rooms III.
 * Memory Usage: 140.8 MB, less than 12.50% of Java online submissions for Meeting Rooms III.
 */
@SuppressWarnings("ALL")
public class Q4_2 {

    @Test
    public void test() {
        assertThat(mostBooked(3, Ps.intArray("[[0,10],[1,9],[2,8],[3,7],[4,6]]"))).isEqualTo(1);
        assertThat(mostBooked(4, Ps.intArray("[[18,19],[3,12],[17,19],[2,13],[7,10]]"))).isEqualTo(0);
        assertThat(mostBooked(2, Ps.intArray("[[0,10],[1,5],[2,7],[3,4]]"))).isEqualTo(0);
        assertThat(mostBooked(3, Ps.intArray("[[1,20],[2,10],[3,5],[4,9],[6,8]]"))).isEqualTo(1);
    }

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> free = new PriorityQueue<>(Comparator.comparingInt(r -> r.roomNumber));
        PriorityQueue<Room> working = new PriorityQueue<>((r1, r2) -> {
            if (r1.nextAvailableTime == r2.nextAvailableTime)
                return Integer.compare(r1.roomNumber, r2.roomNumber);
            return Long.compare(r1.nextAvailableTime, r2.nextAvailableTime);
        });

        for (int i = 0; i < n; i++) {
            free.add(new Room(i));
        }

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        for (int[] meeting : meetings) {
            while (!working.isEmpty() && working.peek().nextAvailableTime <= meeting[0]) {
                free.offer(working.poll());
            }

            Room room = null;
            if (free.isEmpty()) {
                room = working.poll();
            } else {
                room = free.poll();
            }
            room.holdMeeting(meeting);
            working.offer(room);
        }

        free.addAll(working);

        return free.stream()
                .sorted((r1, r2) -> {
                    if (r1.meetingCnt == r2.meetingCnt) {
                        return Integer.compare(r1.roomNumber, r2.roomNumber);
                    }
                    return Integer.compare(r2.meetingCnt, r1.meetingCnt);
                }).findFirst().get().roomNumber;
    }

    class Room {
        int roomNumber;
        int meetingCnt = 0;
        long nextAvailableTime = -1;

        public Room(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public void holdMeeting(int[] meeting) {
            int duration = meeting[1] - meeting[0];
            this.nextAvailableTime = Math.max(this.nextAvailableTime, meeting[0]) + duration;
            meetingCnt++;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "roomNumber=" + roomNumber +
                    ", meetingCnt=" + meetingCnt +
                    ", nextAvailableTime=" + nextAvailableTime +
                    '}';
        }
    }

}
