package lv2;

public class K_nextNumber {

	public static void main(String[] args) {
		System.out.println(solution(78) == 83);
		System.out.println(solution(15) == 23);

	}
	
    static public int solution(int n) {
    	int countN = countOne(n);
        for(int i =n+1; ; i++) {
        	if(countN == countOne(i))
        		return i;
        }
    }
    
    static public int countOne(int n){
    	int count = 0;
    	while(n>1) {
    		if(n%2 == 1) count ++;
    		n /= 2;
    	}
    	if(n==1) count ++;
    	
    	return count;
    }

}