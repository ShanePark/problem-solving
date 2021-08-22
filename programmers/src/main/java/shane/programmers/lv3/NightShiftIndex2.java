package shane.programmers.lv3;

import java.util.PriorityQueue;

public class NightShiftIndex2 {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3})==12);
        System.out.println(solution(1, new int[]{2, 1, 2})==6);
        System.out.println(solution(3, new int[]{1, 1})==0);
    }

    public static long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i :works){
            pq.add(-i);
        }

        for(int i=0; i<n; i++){
            int max = -pq.poll();
            if(max ==0){
                return 0;
            }
            pq.add(-(max-1));
        }

        long sum = 0;
        for(int i : pq){
            sum += (long) i * i;
        }

        return sum;

    }

}
