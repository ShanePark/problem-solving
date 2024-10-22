package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoPlayer {

    @Test
    public void test() {
        assertThat(solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"})).isEqualTo("13:00");
        assertThat(solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"})).isEqualTo("06:55");
        assertThat(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"})).isEqualTo("04:17");
        assertThat(solution("07:22", "07:05", "00:15", "04:07", new String[]{"next", "next"})).isEqualTo("07:22");
        assertThat(solution("07:22", "00:05", "00:15", "04:07", new String[]{"prev", "prev"})).isEqualTo("00:00");
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Time cur = new Time(stringToSec(pos), stringToSec(op_start), stringToSec(op_end), stringToSec(video_len));
        for (String command : commands) {
            cur.command(command);
        }
        return cur.toString();
    }

    static class Time {
        int sec;
        final int opStart;
        final int opEnd;
        final int max;

        Time(int cur, int opStart, int opEnd, int max) {
            this.sec = cur;
            this.opStart = opStart;
            this.opEnd = opEnd;
            this.max = max;
            checkValidation();
            checkOpening();
        }

        private void checkValidation() {
            this.sec = Math.max(0, this.sec);
            this.sec = Math.min(max, this.sec);
        }

        private void checkOpening() {
            if (opStart <= sec && sec <= opEnd) {
                this.sec = opEnd;
            }
        }

        public void prev() {
            this.sec -= 10;
            checkValidation();
            checkOpening();
        }

        public void next() {
            this.sec += 10;
            checkValidation();
            checkOpening();
        }

        @Override
        public String toString() {
            int min = this.sec / 60;
            int sec = this.sec % 60;
            return String.format("%02d", min) + ":" + String.format("%02d", sec);
        }

        public void command(String command) {
            switch (command) {
                case "next":
                    this.next();
                    break;
                case "prev":
                    this.prev();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private int stringToSec(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}
