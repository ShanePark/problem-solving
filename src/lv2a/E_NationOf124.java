package lv2a;

public class E_NationOf124 {

	public static void main(String[] args) {
		for(int i=1; i<11; i++)
			System.out.println((solution(i)));
	}
	
    static public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        
        while(n>=3) {
        	if(n%3 !=0) {
        		sb.append(n%3);
        		n /= 3;
        	}else{
        		sb.append(4);
        		n = n/3-1;
        	}
        }
        if(n != 0)
         sb.append(n);
        sb.reverse();
        
        String answer = sb.toString();
        
        
        return answer;
    }

}
