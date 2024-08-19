package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime34msBeats9.01%
 */
public class Q650_2KeysKeyboard {

    @Test
    public void test() {
        assertThat(minSteps(3)).isEqualTo(3);
        assertThat(minSteps(1)).isEqualTo(0);
        assertThat(minSteps(4)).isEqualTo(4);
        assertThat(minSteps(6)).isEqualTo(5);
    }

    @Test
    public void tle() {
        assertThat(minSteps(199)).isEqualTo(199);
    }

    public int minSteps(int n) {
        Queue<Status> q = new LinkedList<>();
        Set<Status> visited = new HashSet<>();
        int step = 0;
        q.offer(new Status());
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Status poll = q.poll();
                if (poll.length == n) {
                    return step;
                }
                // copy
                if (poll.copy != poll.length) {
                    Status copy = poll.copy();
                    if (visited.add(copy)) {
                        q.offer(copy);

                    }
                }
                // paste
                Status paste = poll.paste();
                if (paste.length <= n && visited.add(paste)) {
                    q.offer(paste);
                }
            }
            step++;
        }
        return -1;
    }

    static class Status {
        int length;
        int copy;

        public Status() {
            this.length = 1;
            this.copy = 0;
        }

        private Status(int length, int copy) {
            this.length = length;
            this.copy = copy;
        }

        public Status copy() {
            if (this.length == this.copy)
                throw new RuntimeException("already copied");
            return new Status(this.length, this.length);
        }

        public Status paste() {
            return new Status(this.length + this.copy, this.copy);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Status)) return false;
            Status status = (Status) o;
            return length == status.length && copy == status.copy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(length, copy);
        }
    }

}
