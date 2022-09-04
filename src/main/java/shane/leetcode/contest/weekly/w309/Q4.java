package shane.leetcode.contest.weekly.w309;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Didn't consider the case when most rooms are available after long time
 */
public class Q4 {

    @Test
    public void test() {
//        assertThat(mostBooked(4, STool.convertToIntArray("[[18,19],[3,12],[17,19],[2,13],[7,10]]"))).isEqualTo(0);
        assertThat(mostBooked(2, STool.convertToIntArray("[[0,10],[1,5],[2,7],[3,4]]"))).isEqualTo(0);
        assertThat(mostBooked(3, STool.convertToIntArray("[[0,10],[1,9],[2,8],[3,7],[4,6]]"))).isEqualTo(1);
        assertThat(mostBooked(3, STool.convertToIntArray("[[1,20],[2,10],[3,5],[4,9],[6,8]]"))).isEqualTo(1);
    }

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> rooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            rooms.offer(new Room(i, 0));
        }

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        for (int[] meeting : meetings) {
            Room room = rooms.poll();
            room.holdMeeting(meeting);
            rooms.offer(room);
        }

        return rooms.stream()
                .sorted((r1, r2) -> {
                    if (r1.meetingCnt == r2.meetingCnt) {
                        return Integer.compare(r1.roomNumber, r2.roomNumber);
                    }
                    return Integer.compare(r2.meetingCnt, r1.meetingCnt);
                }).findFirst().get().roomNumber;
    }

    class Room implements Comparable {
        int roomNumber;
        int meetingCnt;
        int nextAvailableTime;

        public Room(int roomNumber, int meetingCnt) {
            this.roomNumber = roomNumber;
            this.meetingCnt = meetingCnt;
            this.nextAvailableTime = 0;
        }

        @Override
        public int compareTo(Object o) {
            Room r = (Room) o;
            if (nextAvailableTime == r.nextAvailableTime) {
                return Integer.compare(roomNumber, r.roomNumber);
            }
            return Integer.compare(nextAvailableTime, r.nextAvailableTime);
        }

        public void holdMeeting(int[] meeting) {
            int startTime = meeting[0];
            int duration = meeting[1] - startTime;
            nextAvailableTime = Math.max(nextAvailableTime, startTime) + duration;
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
