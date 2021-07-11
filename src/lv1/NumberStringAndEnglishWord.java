package lv1;

public class NumberStringAndEnglishWord {

	public static void main(String[] args) {
		System.out.println(solution("12412zero32"));

	}
	
    public static int solution(String s) {
    	String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	int length = numbers.length;
    	StringBuffer sb = new StringBuffer(s);
    	int answer = 0;
    	for(int i=0; i<length; i++) {
    		try {
    			answer = Integer.parseInt(sb.toString());
    			return answer;
    		}catch(NumberFormatException e) {
    			sb = new StringBuffer(sb.toString().replaceAll(numbers[i], String.valueOf(i)));
    		}
    	}
        return Integer.parseInt(sb.toString());
    }

}
