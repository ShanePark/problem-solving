package lv2a;

public class K_ExpresNumber {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}
	
    static public int solution(int n) {
    	int sum=0;
    	for(int i=1; i<=n; i++) {
    		if(tryFrom(i,n))
    			sum++;
    	}
    	return sum;
        
    }
    
    static public boolean tryFrom(int from, int answer) {
    	int sum = 0;
    	while(sum < answer) {
    		sum += from++;
    	}
    	if(sum == answer) return true;
    	else return false;
    	
    }

}
