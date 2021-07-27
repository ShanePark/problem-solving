package shane.programmers.lv2b;

public class Y_ExpectGame {

	public static void main(String[] args) {
		System.out.println(solution(8,4,7));
		System.out.println(solution(8,4,5));
		System.out.println(solution(16,1,9));

	}
	
    public static int solution(int n, int a, int b) {
        int answer = 1;
        
        while(a != b) {
        	int min = Math.min(a, b);
        	int max = Math.max(a, b);
        	if(min%2 ==1 && min+1 == max) {
        		return answer;
        	}else {
        		a = (a-1)/2+1;
        		b = (b-1)/2+1;
        		answer++;
        	}
        }

        return answer;
    }

}
