package shane.programmers.lv3;

public class Immigration3 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
        System.out.println(solution(2, new int[]{1, 2, 2, 2, 100}));
    }

    public static long solution(long n, int[] times)  {
        long left = 0;
        long right = n * 1_000_000_000;

        while(left != right){
            long mid = (left + right) / 2 ;
            long processPower = processPower(mid, times);
            if(processPower >= n){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static long processPower(long time, int[] times) {
         long power = 0;
         for(int i : times){
             power += (time / i);
         }
         return power;
    }
}
