package shane.programmers.lv1;


public class GetMiddleNumber {

	static String solutionG(String s) {
		String answer = "";
		if(s.length()%2==1){
			answer += s.substring(s.length()/2,s.length()/2+1);
		}else{
			answer += s.substring(s.length()/2-1,s.length()/2+1);
		}
			
		return answer;
	}

	public static void main(String[] args) {
		String s = "qwer";
		System.out.println(solutionG(s));

	}

}
