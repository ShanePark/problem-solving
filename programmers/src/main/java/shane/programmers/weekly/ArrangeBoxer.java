package shane.programmers.weekly;

import java.util.*;

public class ArrangeBoxer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"})));  // 3,4,1,2
        System.out.println(Arrays.toString(solution(new int[]{145,92,86}, new String[]{"NLW","WNL","LWN"})));  // 2,3,1
        System.out.println(Arrays.toString(solution(new int[]{60,70,60}, new String[]{"NNN","NNN","NNN"})));  // 2,1,3
    }

    static class Boxer{
        int number, weight, heavierKillingCnt;
        double winRate;
        public Boxer(int number, int weight, String history, int[] weights){
            this.number = number;
            this.weight = weight;
            char[] arr = history.toCharArray();
            int win=0, lose=0;
            for(int i=0; i<arr.length; i++){
                char c = arr[i];
                if(c=='W'){
                    win++;
                    if(weights[i] > weight){
                        heavierKillingCnt++;
                    }
                }else if(c=='L'){
                    lose++;
                }
            }
            if(win+lose > 0)
                this.winRate = (win) / (double)(win+lose);
        }
    }

    public static int[] solution(int[] weights, String[] head2head) {
        List<Boxer> list = new ArrayList<>();
        for(int i=0; i<weights.length; i++){
            list.add(new Boxer(i+1, weights[i], head2head[i], weights));
        }

        return list.stream()
                .sorted((b1,b2) -> b1.winRate!=b2.winRate ? (b2.winRate>b1.winRate?1:-1) : b1.heavierKillingCnt!=b2.heavierKillingCnt ? b2.heavierKillingCnt-b1.heavierKillingCnt : b1.weight!=b2.weight? b2.weight-b1.weight : b1.number-b2.number)
                .mapToInt(b -> b.number).toArray();
    }
}
