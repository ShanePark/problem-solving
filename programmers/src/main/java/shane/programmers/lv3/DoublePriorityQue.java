package shane.programmers.lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DoublePriorityQue {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[]{"I 16","D 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 7","I 5","I -5","D -1"})));
        System.out.println(Arrays.toString(solution(new String[]{"D -1","I 5","I -5","D -1"})));

    }

    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        int total = 0;

        for(String str : operations){
            if("D -1".equals(str)){
                if(total>0){
                    minPq.remove(-pq.poll());
                    total--;
                }
            }else if("D 1".equals(str)){
                if(total>0){
                    pq.remove(-minPq.poll());
                    total--;
                }
            }else{
                int number = Integer.parseInt(str.substring(2));
                pq.add(number);
                minPq.add(-number);
                total++;
            }
        }

        if(total > 0){
            return new int[] {-minPq.peek(), pq.peek()};
        }else{
            return new int[] {0,0};
        }
    }

}
