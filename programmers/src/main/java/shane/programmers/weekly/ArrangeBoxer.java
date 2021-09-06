package shane.programmers.weekly;

import java.util.*;

public class ArrangeBoxer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"})));  // 3,4,1,2
        System.out.println(Arrays.toString(solution(new int[]{145,92,86}, new String[]{"NLW","WNL","LWN"})));  // 2,3,1
        System.out.println(Arrays.toString(solution(new int[]{60,70,60}, new String[]{"NNN","NNN","NNN"})));  // 2,1,3
    }

    static class Boxer{
        int number;
        int weight;
        int heavierKillingCnt;
        int win;
        int lose;
        double winRate;
        public Boxer(int number, int weight){
            this.number = number;
            this.weight = weight;
        }
        public void calcHistory(String history, int[] weights){
            char[] arr = history.toCharArray();
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
            Boxer boxer = new Boxer(i+1, weights[i]);
            boxer.calcHistory(head2head[i], weights);
            list.add(boxer);
        }

        // 기준에 맞게 list를 정렬
        list.sort(new Comparator<Boxer>() {
            @Override
            public int compare(Boxer o1, Boxer o2) {
                if(o1.winRate != o2.winRate){
                    return o2.winRate > o1.winRate ? 1 : -1;
                }else if(o1.heavierKillingCnt != o2.heavierKillingCnt){
                    return o2.heavierKillingCnt - o1.heavierKillingCnt;
                } else if (o1.weight != o2.weight) {
                    return o2.weight - o1.weight;
                }else{
                    return o1.number - o2.number;
                }
            }
        });

        // 정렬된 list를 순회하며 번호 담은 Array 만들어 출력. 끝.
        return list.stream().mapToInt(b -> b.number).toArray();

    }
}
