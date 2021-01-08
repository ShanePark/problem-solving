package lv1;


public class PressKeyPad {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers,hand));

	}
	
    static public String solution(int[] numbers, String hand) {
        String answer = "";
        final int SIZE = numbers.length;
        String lFinger = "*";
        String rFinger = "#";
        int lDistance,rDistance;
        for(int i=0; i<SIZE; i++) {
        	if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
        		answer += "L";
        	}
        	else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
        		answer += "R";
        	}
        	lDistance=distance(numbers[i]+"",lFinger);
        	rDistance=distance(numbers[i]+"",rFinger);
        	
        }
        
        return answer;
    }
    static int distance(String key, String finger) {
    	if(key.equals(finger))
    		return 0;
    	switch(key) {
    	case "2":{
    		switch(finger) {
    		case "1":
    		case "5":
    		case "3":return 1;
    		case "4":
    		case "6":return 2;
    		case "8":return 4;
    		case "7":
    		case "9":return 5;
    		case "0":return 9;
    		case "*":
    		case "#":return 10;
    		}
    	}
    	case "5":{
    		switch(finger) {
    		case "2":
    		case "4":
    		case "6":
    		case "8":return 1;
    		case "1":
    		case "3":
    		case "7":
    		case "9":return 2;
    		case "0":return 4;
    		case "*":
    		case "#":return 5;
    		}	
    	}
    	case "8":{
    		switch(finger) {
    		case "5":
    		case "7":
    		case "9":
    		case "0":return 1;
    		case "4":
    		case "6":
    		case "*":
    		case "#":return 2;
    		case "2":return 4;
    		case "1":
    		case "3":return 5;
    		}	
    	}
    	case "0":{
    		switch(finger) {
    		case "8":
    		case "*":
    		case "#":return 1;
    		case "7":
    		case "9":return 2;
    		case "5":return 4;
    		case "4":
    		case "6":return 5;
    		case "2":return 9;
    		case "1":
    		case "3":return 10;
    		}	
    	}
    	default :
    		return 0;
    	
    	
    	}
    	
    }

}
