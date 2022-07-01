package shane.programmers.challenge2022.kakao2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.41ms, 72.9MB)
 * 테스트 2 〉	실패 (0.38ms, 72.6MB)
 * 테스트 3 〉	실패 (0.43ms, 59.1MB)
 * 테스트 4 〉	실패 (0.36ms, 72.3MB)
 * 테스트 5 〉	통과 (0.36ms, 59.1MB)
 * 테스트 6 〉	통과 (0.44ms, 68.5MB)
 * 테스트 7 〉	통과 (0.46ms, 73.8MB)
 * 테스트 8 〉	통과 (0.36ms, 61.1MB)
 * 테스트 9 〉	통과 (0.41ms, 62.1MB)
 * 테스트 10 〉	실패 (0.37ms, 70.4MB)
 * 테스트 11 〉	통과 (0.38ms, 68.1MB)
 * 테스트 12 〉	실패 (0.36ms, 69.2MB)
 * 테스트 13 〉	통과 (0.37ms, 59.3MB)
 * 테스트 14 〉	실패 (0.36ms, 73.4MB)
 * 테스트 15 〉	실패 (0.35ms, 58.7MB)
 * 테스트 16 〉	실패 (0.41ms, 61.1MB)
 * 테스트 17 〉	통과 (0.36ms, 62.4MB)
 * 테스트 18 〉	통과 (0.36ms, 59.7MB)
 * 테스트 19 〉	통과 (0.39ms, 59.6MB)
 * 테스트 20 〉	통과 (0.50ms, 68MB)
 * 테스트 21 〉	실패 (0.51ms, 70.9MB)
 * 테스트 22 〉	통과 (0.39ms, 68.6MB)
 * 테스트 23 〉	통과 (0.46ms, 73.3MB)
 * 테스트 24 〉	통과 (0.39ms, 74.3MB)
 * 테스트 25 〉	통과 (0.42ms, 62.4MB)
 * 채점 완료
 */
public class K4 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})));
    }

    static class Target implements Comparable<Target> {
        int index;
        int score;
        int arrowsNecessary;
        double scorePerArrow;

        public Target(int index, int score, int necessary) {
            this.index = index;
            this.score = score;
            this.arrowsNecessary = necessary;
            scorePerArrow = (double) score / necessary;
        }

        @Override
        public String toString() {
            return "Target{" +
                    "index=" + index +
                    ", score=" + score +
                    ", arrowsNecessary=" + arrowsNecessary +
                    ", scorePerArrow=" + scorePerArrow +
                    '}';
        }

        @Override
        public int compareTo(Target o) {
            return o.scorePerArrow < this.scorePerArrow ? -1 : 1;
        }
    }

    public static int[] solution(int n, int[] info) {
        List<Target> list = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            int score = info[i] == 0 ? 10 - i : (10 - i) * 2;
            int necessary = info[i] == 0 ? 1 : info[i] + 1;
            Target target = new Target(i, score, necessary);
            list.add(target);
        }

        int[] answer = new int[11];
        Collections.sort(list);

        for (int i = 0; i < 11 && n > 0; i++) {
            Target target = list.get(i);
            if (target.arrowsNecessary <= n) {
                n -= list.get(i).arrowsNecessary;
                answer[target.index] = target.arrowsNecessary;
            }
        }

        // 어피치 못 이길 경우 처리
        int score = 0;
        for (int i = 0; i < info.length; i++) {
            int apeach = info[i];
            int mine = answer[i];
            if (apeach == 0 && mine == 0) continue;
            if (apeach >= mine) {
                score -= 10 - i;
            } else {
                score += 10 - i;
            }
        }

        if (score <= 0) {
            return new int[]{-1};
        }

        // n 이 남았을 경우 처리
        if (n > 0) {
            answer[10] += n;
        }

        return answer;
    }

}
