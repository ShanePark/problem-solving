package shane.programmers.challenge2021.naverwebtoon;

public class Programming3 {
	
	public static void main(String[] args) {
		System.out.println(solution("aabcbcd","abc"));
		System.out.println(solution("aaaaabbbbb","ab"));
	}
	
	   public static int solution(String s, String t) {
	        int result = 0;
	        int length = t.length();
	        StringBuffer sb = new StringBuffer(s);
	        while(true) {
	        	int index = sb.indexOf(t);
	        	if(index == -1) {
	        		break;
	        	}else {
	        		sb = sb.delete(index, index+length);
	        		result++;
	        	}
	        	
	        }

	        return result;
	    }
	
   
}



















