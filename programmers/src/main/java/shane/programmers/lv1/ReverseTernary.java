package shane.programmers.lv1;


import java.util.ArrayList;

/*
 * 3진법 뒤집기
문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.

 */
public class ReverseTernary {

	public static void main(String[] args) {
		System.out.println(new ReverseSolution().solution(125));

	}

}

class ReverseSolution {
    public int solution(int n) {
    	ArrayList<Integer> list = new ArrayList<>();
    	while(n>0){
    		list.add(n%3);
    		n/=3;
    	}
    	System.out.println(list.toString());
    	int three =1;
    	int answer=0;
    	for(int i=list.size()-1 ; i>=0; i--){
    		answer += list.get(i)*three;
    		three *= 3;
    	}

    		
    		
    		
    	return answer;

    }
}