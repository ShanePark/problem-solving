package shane.programmers.lv3;

import java.util.*;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.06ms, 68.1MB)
 * 테스트 2 〉	실패 (0.16ms, 72.8MB)
 * 테스트 3 〉	실패 (0.20ms, 57.8MB)
 * 테스트 4 〉	실패 (0.24ms, 70.4MB)
 * 테스트 5 〉	실패 (0.20ms, 74.4MB)
 * 테스트 6 〉	실패 (0.31ms, 59.8MB)
 * 테스트 7 〉	실패 (0.28ms, 60.1MB)
 * 테스트 8 〉	통과 (0.14ms, 60.4MB)
 * 채점 결과
 * 정확성: 25.0
 * 합계: 25.0 / 100.0
 */
public class ConnectIslands {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    public static int solution(int n, int[][] costs) {
        Set<Integer> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, costs);
        int total = 0;
        while (set.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIndex=0;
            int size = list.size();
            int removeCount = 0;
            for (int i = 0; i < size-removeCount; i++) {
                int[] arr = list.get(i);
                if(set.contains(arr[0]) && set.contains(arr[1])){
                    list.remove(i);
                    removeCount++;
                    i--;
                }else if(arr[2] < min){
                    min = arr[2];
                    minIndex = i;
                }
            }
            int[] arr = list.get(minIndex);
            set.add(arr[0]);
            set.add(arr[1]);
            total += arr[2];
        }
        return total;
    }

}