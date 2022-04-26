package shane.programmers.lv2b;

public class O_BaseN {

	public static void main(String[] args) {
		O_BaseN solution = new O_BaseN();
		System.out.println(solution.solution(2, 4, 2, 1));
		System.out.println(solution.solution(16, 16, 2, 1));
		System.out.println(solution.solution(16, 16, 2, 2));
	}
	
    public String solution(int n, int t, int m, int p) {
    	StringBuffer sb = new StringBuffer();
    	int number = 0;
    	while(sb.length() < m * t) {
			sb.append(toBaseN(number, n));
			number++;
		}
    	
    	StringBuffer answer = new StringBuffer();
    	int index = 0;
    	while(answer.length() < t) {
    		if(index % m == p - 1) {
    			answer.append(sb.charAt(index));
    		}
    		index++;
    	}
    	
        return answer.toString();
    }
    
    public String toBaseN(int number, int n){
    	String[] numArr = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    	StringBuffer sb = new StringBuffer();
    	while(number >= n) {
    		sb.insert(0,numArr[number % n]);
    		number = number / n;
    	}
    	sb.insert(0, numArr[number]);
    	return sb.toString();
    }

}





