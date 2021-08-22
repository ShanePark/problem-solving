package shane.programmers.lv3;

/**
 *채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.04ms, 68.3MB)
 * 테스트 2 〉	통과 (0.04ms, 72MB)
 * 테스트 3 〉	통과 (0.03ms, 59.6MB)
 * 테스트 4 〉	통과 (0.04ms, 71.9MB)
 * 테스트 5 〉	통과 (0.09ms, 70.9MB)
 * 테스트 6 〉	통과 (0.06ms, 57.8MB)
 * 테스트 7 〉	통과 (0.03ms, 58MB)
 * 테스트 8 〉	통과 (0.14ms, 71.6MB)
 * 테스트 9 〉	통과 (0.29ms, 73.1MB)
 * 테스트 10 〉	통과 (0.04ms, 72.3MB)
 * 테스트 11 〉	통과 (0.09ms, 71.7MB)
 * 테스트 12 〉	실패 (0.04ms, 69.3MB)
 * 테스트 13 〉	통과 (0.03ms, 73.7MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 80.0
 * 효율성: 0.0
 * 합계: 80.0 / 100.0
 */
public class NightShiftIndex {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
        System.out.println(solution(1, new int[]{2, 1, 2}));
        System.out.println(solution(3, new int[]{1, 1}));
    }

    public static long solution(int n, int[] works) {
        for (int i = 0; i < n; i++) {
            if (--works[findMaxIndex(works)] == 0) {
                return 0;
            }
        }

        long sum = 0;
        for (int i = 0; i < works.length; i++) {
            sum += Math.pow(works[i], 2);
        }

        return sum;

    }

    public static int findMaxIndex(int[] works) {
        int max = works[0];
        int maxIndex = 0;
        for (int i = 0; i < works.length; i++) {
            if (max < works[i]) {
                max = works[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
