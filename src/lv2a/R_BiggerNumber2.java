package lv2a;

public class R_BiggerNumber2 {

	public static void main(String[] args) {
		System.out.println(solution("1924",2));
		System.out.println(solution("1231234",3));
		System.out.println(solution("4177252841",4));
		System.out.println(solution("11111111",4));
	}
	
	 static public String solution(String number, int k) {
		 
		 StringBuffer sb = new StringBuffer(number);
		 int i = 1;
		 while(0 < k && i < sb.length()) {
			 if(sb.charAt(i-1) < sb.charAt(i)) {
				 sb.deleteCharAt(i-1);
				 i = i > 1 ? i-1 : i;
				 k--;
			 }else {
				 i++;
			 }
		 }
		 
		 return sb.substring(0,sb.length()-k);
		 
	 }
	 

}
