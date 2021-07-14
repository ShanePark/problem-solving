package shane.programmers.lv2b;

public class G_Joystick2 {
	
	public static void main(String[] args) {
		System.out.println(solution("JAZ")); //11
		System.out.println(solution("JEROEN")); //56
		System.out.println(solution("JAN")); //23
		System.out.println(solution("BAAAAABBB"));
	}
	
    public static int solution(String name) {
    	
    	final int length = name.length();
    	
    	StringBuffer sb = new StringBuffer();
    	for(int i=0; i<length; i++) {
    		sb.append('A');
    	}
    	
    	int answer = processChar(name.charAt(0));
    	sb.setCharAt(0, name.charAt(0));
    	
    	int index = 0;
    	while(!name.equals(sb.toString())) {
    		int leftDistance = findLeftDistance(index, sb, name);
    		int rightDistance = findRightDistance(index, sb, name);
    		if(leftDistance < rightDistance) {
    			// move to the left
    			answer += leftDistance;
    			index = ((index - leftDistance) < 0) ? (length - (leftDistance - index)) : (index - leftDistance);
    		}else {
    			// move to right
    			answer += rightDistance;
    			index = ((index + rightDistance) > length-1) ? (index + rightDistance - length) : (index + rightDistance);  
    		}
    		// process
    		answer += processChar(name.charAt(index));
    		sb.setCharAt(index, name.charAt(index));
    		
    	}
    	
    	return answer;
    	
    }
    
    public static int processChar(char c) {
    	int number = c - 'A';
    	return number > 13 ? 26 - number : number;
    }
    
    public static int findRightDistance(int index, StringBuffer sb, String name) {
    	int length = sb.length();
    	int temp = (index == (length -1)) ? 0 : index + 1;
    	while(index != temp) {
    		if(sb.charAt(temp) != name.charAt(temp)) {
    			int distance = index < temp ? temp - index : length - index + temp;
    			return distance;
    		}
    		temp = temp == length-1 ? 0 : temp + 1;
    	}
    	return 0;
    }
    
    public static int findLeftDistance(int index, StringBuffer sb, String name) {
    	int length = sb.length();
    	int temp = (index==0) ? length-1 : index-1;
    	while(index != temp) {
    		if(sb.charAt(temp) != name.charAt(temp)) {
    			int distance = index < temp ? length + index - temp : index - temp;
    			return distance;
    		}
    		temp = (temp == 0) ? length-1 : temp -1;
    	}
    	return 0;
    }
    
    
}





