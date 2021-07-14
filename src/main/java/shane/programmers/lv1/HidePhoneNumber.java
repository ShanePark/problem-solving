package shane.programmers.lv1;

public class HidePhoneNumber {

	public static void main(String[] args) {
		
		System.out.println(solution("01033334444"));

	}
	
   static public String solution(String phone_number) {
        String answer = "";
        for(int i=0; i<phone_number.length()-4; i++)
        	answer += "*";
        answer += phone_number.substring(phone_number.length()-4,phone_number.length());
        
        return answer;
    }

}
