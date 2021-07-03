package lv2;

public class R_BiggerNumber_NotSolved {

	public static void main(String[] args) {
		System.out.println(solution("1924",2));
		System.out.println(solution("1231234",3));
		System.out.println(solution("4177252841",4));
		System.out.println(solution("11111111",4));
	}
	
	 static public String solution(String number, int k) {
		 
		 StringBuffer sb = new StringBuffer(number);
		 int length = number.length();
		 int cnt = 0;
		 while(k > 0) {
			 if(cnt == length - 1) {
				 return sb.substring(0,length-k);
			 }else {
				 cnt ++;
				 if(sb.charAt(cnt-1) < sb.charAt(cnt)) {
					 sb.deleteCharAt(cnt-1);
					 cnt = 0;
					 length = sb.length();
					 k--;
				 }
			 }
		 }
		 
		 return sb.toString();
		 
	 }
	 

}
