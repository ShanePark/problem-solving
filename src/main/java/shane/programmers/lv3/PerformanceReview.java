package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.53ms, 84.3MB)
 * 테스트 2 〉	통과 (0.35ms, 75.2MB)
 * 테스트 3 〉	통과 (0.44ms, 70.4MB)
 * 테스트 4 〉	통과 (0.54ms, 73MB)
 * 테스트 5 〉	통과 (0.61ms, 74MB)
 * 테스트 6 〉	통과 (0.24ms, 76.8MB)
 * 테스트 7 〉	통과 (0.60ms, 66.5MB)
 * 테스트 8 〉	통과 (0.44ms, 75.4MB)
 * 테스트 9 〉	통과 (0.22ms, 76MB)
 * 테스트 10 〉	통과 (0.72ms, 81.3MB)
 * 테스트 11 〉	통과 (1.57ms, 72.7MB)
 * 테스트 12 〉	통과 (1.11ms, 78.8MB)
 * 테스트 13 〉	통과 (0.61ms, 74.5MB)
 * 테스트 14 〉	통과 (2.31ms, 80.6MB)
 * 테스트 15 〉	통과 (1.38ms, 83.1MB)
 * 테스트 16 〉	통과 (8.39ms, 79.6MB)
 * 테스트 17 〉	통과 (19.07ms, 89.1MB)
 * 테스트 18 〉	통과 (18.39ms, 88MB)
 * 테스트 19 〉	통과 (6.75ms, 109MB)
 * 테스트 20 〉	통과 (10.34ms, 107MB)
 * 테스트 21 〉	실패 (시간 초과)
 * 테스트 22 〉	통과 (430.43ms, 112MB)
 * 테스트 23 〉	통과 (9.34ms, 129MB)
 * 테스트 24 〉	실패 (시간 초과)
 * 테스트 25 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 88.0
 * 합계: 88.0 / 100.0
 */
public class PerformanceReview {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[2,2],[1,4],[3,2],[3,2],[2,1]]"))).isEqualTo(4);
        assertThat(solution(Ps.intArray("[[0,0],[1,4],[3,2],[3,2],[2,1]]"))).isEqualTo(-1);
    }

    public int solution(int[][] scores) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            Person person = new Person(i, scores[i][0], scores[i][1]);
            people.add(person);
        }

        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            for (int j = 0; j < people.size(); j++) {
                Person other = people.get(j);
                if (person.attitude < other.attitude && person.rating < other.rating) {
                    if (person.index == 0)
                        return -1;
                    people.remove(i--);
                    break;
                }
            }
        }

        Collections.sort(people);
        int curRank = 0;
        int lastScore = Integer.MAX_VALUE;
        int sameScoreCnt = 0;
        for (int i = 0; i < people.size(); i++) {
            Person cur = people.get(i);
            int total = cur.getTotal();
            if (lastScore == total) {
                sameScoreCnt++;
            } else {
                curRank += sameScoreCnt + 1;
            }
            if (cur.index == 0)
                return curRank;
        }

        return -1;
    }

    static class Person implements Comparable<Person> {
        final int index;
        final int attitude;
        final int rating;

        public Person(int index, int attitude, int rating) {
            this.index = index;
            this.attitude = attitude;
            this.rating = rating;
        }

        @Override
        public int compareTo(Person o) {
            return (o.rating + o.attitude) - (this.rating + this.attitude);
        }

        public int getTotal() {
            return this.attitude + this.rating;
        }
    }

}
