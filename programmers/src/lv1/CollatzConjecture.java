package lv1;


public class CollatzConjecture {

	public static void main(String[] args) {
		System.out.println(new Col_Solution().solution(626331));

	}
	


}

class Col_Solution {
    public int solution(int num) {
        int answer = 0;
        long long_num = num;
        while(long_num!= 1){
        	if(long_num%2 ==0){
        		long_num /= 2;
        	}else{
        		long_num = long_num *3 +1;
        	}
        	answer++;
        	if(answer == 500)
        		return -1;
        	
        }
        
        
        return answer;
    }
}