package shane.programmers.lv2c;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.61ms, 68.4MB)
 * 테스트 2 〉	실패 (0.75ms, 76.2MB)
 * 테스트 3 〉	실패 (0.75ms, 73.6MB)
 * 테스트 4 〉	실패 (0.68ms, 78.5MB)
 * 테스트 5 〉	통과 (0.67ms, 69.6MB)
 * 테스트 6 〉	통과 (0.69ms, 75MB)
 * 테스트 7 〉	통과 (0.62ms, 74.1MB)
 * 테스트 8 〉	통과 (0.73ms, 72.4MB)
 * 테스트 9 〉	통과 (0.71ms, 73MB)
 * 테스트 10 〉	실패 (0.61ms, 68.1MB)
 * 테스트 11 〉	통과 (0.72ms, 73.3MB)
 * 테스트 12 〉	실패 (0.62ms, 73.3MB)
 * 테스트 13 〉	통과 (0.75ms, 74.4MB)
 * 테스트 14 〉	실패 (0.74ms, 73.5MB)
 * 테스트 15 〉	실패 (0.67ms, 77.5MB)
 * 테스트 16 〉	실패 (0.67ms, 77.2MB)
 * 테스트 17 〉	통과 (0.66ms, 78.3MB)
 * 테스트 18 〉	통과 (0.66ms, 71.7MB)
 * 테스트 19 〉	통과 (0.68ms, 75.1MB)
 * 테스트 20 〉	통과 (0.69ms, 74.7MB)
 * 테스트 21 〉	실패 (0.64ms, 75.9MB)
 * 테스트 22 〉	통과 (0.71ms, 77.5MB)
 * 테스트 23 〉	통과 (0.75ms, 79.1MB)
 * 테스트 24 〉	통과 (0.65ms, 77.3MB)
 * 테스트 25 〉	통과 (0.77ms, 75.6MB)
 * 채점 결과
 * 정확성: 67.9
 * 합계: 67.9 / 100.0
 */
public class Archery {

    @Test
    void test() {
        Assertions.assertThat(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})).containsExactly(0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0);
        Assertions.assertThat(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).containsExactly(-1);
        Assertions.assertThat(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})).containsExactly(1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0);
        Assertions.assertThat(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})).containsExactly(1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2);
    }

    public int[] solution(int n, int[] info) {
        List<Score> list = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            list.add(new Score(i, info[i]));
        }
        int scoreGap = 0;
        list.sort((s1, s2) -> {
            if (s1.scorePerArrow == s2.scorePerArrow) {
                return s1.index - s2.index;
            }
            return (s2.scorePerArrow - s1.scorePerArrow) > 0 ? 1 : -1;
        });

        int[] answer = new int[11];

        for (int i = 0; i < info.length; i++) {
            Score score = list.get(i);
            if (score.arrow + 1 <= n) {
                n -= (score.arrow + 1);
                scoreGap += (10 - score.index);
                answer[score.index] = score.arrow + 1;
            } else if (score.arrow > 0) {
                scoreGap -= (10 - score.index);
            }
        }

        if (scoreGap <= 0) {
            return new int[]{-1};
        }

        answer[10] += n;

        return answer;
    }

    class Score {
        int index;
        int arrow;
        double scorePerArrow;

        public Score(int index, int arrow) {
            this.index = index;
            this.arrow = arrow;
            scorePerArrow = (double) (10 - index) / (arrow + 1);
            if (arrow > 0) {
                scorePerArrow *= 2;
            }
        }

        @Override
        public String toString() {
            return "Score{" +
                    "index=" + index +
                    ", arrow=" + arrow +
                    ", scorePerArrow=" + scorePerArrow +
                    '}';
        }
    }

}
