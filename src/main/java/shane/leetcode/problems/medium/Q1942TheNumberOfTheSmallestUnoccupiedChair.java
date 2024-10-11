package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime54msBeats43.27%
 */
public class Q1942TheNumberOfTheSmallestUnoccupiedChair {

    @Test
    public void test() {
        assertThat(smallestChair(Ps.intArray("[[3,10],[1,5],[2,6]]"), 0)).isEqualTo(2);
        assertThat(smallestChair(Ps.intArray("[[1,4],[2,3],[4,6]]"), 1)).isEqualTo(1);
    }

    public int smallestChair(int[][] times, int targetFriend) {
        List<Friend> friendList = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            Friend friend = new Friend(i, times[i][0], times[i][1]);
            friendList.add(friend);
        }
        Collections.sort(friendList);

        TreeSet<Integer> chairs = new TreeSet<>();
        for (int i = 0; i < times.length; i++) {
            chairs.add(i);
        }

        PriorityQueue<Friend> sittingFriends = new PriorityQueue<>(Comparator.comparingInt(f -> f.end));
        for (Friend friend : friendList) {
            int startTime = friend.start;
            while (!sittingFriends.isEmpty() && sittingFriends.peek().end <= startTime) {
                Friend f = sittingFriends.poll();
                chairs.add(f.chair);
            }
            friend.chair = chairs.pollFirst();
            sittingFriends.offer(friend);
            if (friend.index == targetFriend) {
                return friend.chair;
            }
        }

        return -1;
    }

    static class Friend implements Comparable<Friend> {
        final int index;
        final int start;
        final int end;
        int chair;

        Friend(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Friend o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Friend{" +
                    "end=" + end +
                    ", index=" + index +
                    ", start=" + start +
                    '}';
        }
    }

}
