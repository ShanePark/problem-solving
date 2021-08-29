package shane.programmers.lv3;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (18.30ms, 81.3MB)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	실패 (시간 초과)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 테스트 9 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 0.0
 * 합계: 0.0 / 100.0
 */
public class Immigration2 {

    public static void main(String[] args) {

        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times)  {
        long left = 0;
        long right = n * 1_000_000_000;

        while(true){
            long middle = (left + right) / 2 ;
            long processPower = processPower(middle, times);
            if(processPower == n){
                return middle;
            }else if(processPower > n){
                right = middle;
            }else{
                left = middle;
            }
        }
    }

    public static long processPower(long time, int[] times) {
         long power = 0;
         for(int i : times){
             power += time / i;
         }
         return power;
    }
}
