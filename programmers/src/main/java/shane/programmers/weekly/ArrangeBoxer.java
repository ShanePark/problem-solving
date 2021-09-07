package shane.programmers.weekly;

import java.util.*;

public class ArrangeBoxer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"})));  // 3,4,1,2
        System.out.println(Arrays.toString(solution(new int[]{145,92,86}, new String[]{"NLW","WNL","LWN"})));  // 2,3,1
        System.out.println(Arrays.toString(solution(new int[]{60,70,60}, new String[]{"NNN","NNN","NNN"})));  // 2,1,3
    }

    static class Boxer implements Comparable<Boxer>{
        int number, weight, heavierKillingCnt;
        double winRate;
        public Boxer(int number, int weight, String history, int[] weights){
            this.number = number;
            this.weight = weight;
            int win=0, lose=0;
            for(int i=0; i<history.length(); i++){
                char c = history.charAt(i);
                if(c=='W'){
                    win++;
                    if(weights[i] > weight)
                        heavierKillingCnt++;
                }else if(c=='L'){
                    lose++;
                }
            }
            this.winRate = win+lose > 0 ? (double)win/(win+lose) : 0;
        }
        @Override
        public int compareTo(Boxer b) {
            return b.winRate!=winRate? (b.winRate>winRate?1:-1): b.heavierKillingCnt!=heavierKillingCnt? b.heavierKillingCnt-heavierKillingCnt: b.weight!=weight? b.weight-weight: number-b.number;
        }
    }

    public static int[] solution(int[] weights, String[] head2head) {
        List<Boxer> list = new ArrayList<>();
        for(int i=0; i<weights.length; i++)
            list.add(new Boxer(i+1, weights[i], head2head[i], weights));

        return list.stream().sorted().mapToInt(b -> b.number).toArray();
    }
}
