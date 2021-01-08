

public class MakeStrangeString {

	public static void main(String[] args) {
		System.out.println(solution("TRY hello world abcde"));

	}

	static String solution(String s) {
		String answer = "";
		
		for(int i=0,j=0; i<s.length(); i++,j++) {
			
			Character charAt = s.charAt(i);
			if(j%2 ==0)
				charAt = Character.toUpperCase(charAt);
			else
				charAt = Character.toLowerCase(charAt);
			
			answer += charAt;
			
			if(charAt == ' ')
				j=-1;
			
		}
		
		return answer;
	}

}
