package shane.programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.63ms, 69MB)
 * 테스트 2 〉	통과 (0.84ms, 60.6MB)
 * 테스트 3 〉	통과 (0.79ms, 76.8MB)
 * 테스트 4 〉	통과 (0.66ms, 62.2MB)
 * 테스트 5 〉	통과 (0.20ms, 61.9MB)
 * 테스트 6 〉	통과 (0.50ms, 72.4MB)
 * 테스트 7 〉	통과 (0.23ms, 70.9MB)
 * 테스트 8 〉	통과 (0.19ms, 73.7MB)
 * 테스트 9 〉	통과 (0.62ms, 73.7MB)
 * 테스트 10 〉	통과 (0.97ms, 75.7MB)
 * 테스트 11 〉	통과 (0.79ms, 78.4MB)
 * 테스트 12 〉	통과 (0.76ms, 58.4MB)
 * 테스트 13 〉	통과 (1.03ms, 74.4MB)
 * 테스트 14 〉	통과 (0.02ms, 60.9MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	통과 (0.02ms, 51.6MB)
 * 채점 결과
 * 정확성: 70.0
 * 효율성: 5.0
 * 합계: 75.0 / 100.0
 */
public class TheBestSet {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
    }

    public static int[] solution(int n, int s) {
        if (s < n)
            return new int[]{-1};
        int value = s / n;
        int left = s % n;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n-left; i++){
            list.add(value);
        }
        for(int i=0; i<left; i++){
            list.add(value + 1);
        }

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
