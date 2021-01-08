

public class changeStringToInt {

	public static void main(String[] args) {
		System.out.println(new changeStr().solutionCh("-1234"));

	}

}

class changeStr {
    public int solutionCh(String s) {
//    	boolean flag = true;
//    	int i = 0;
//    	if(s.charAt(0) == '-'){
//    		flag = false;
//    		i++;
//    	}
//    	else if(s.charAt(0) == '+')
//    		i++;
//    	
//    	s.substring(i,s.length());
        int answer = Integer.parseInt(s);
        return answer;
    }
}