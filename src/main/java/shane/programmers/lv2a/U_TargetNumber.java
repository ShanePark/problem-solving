package shane.programmers.lv2a;

/**
 *	passed ! +1 point
 */
public class U_TargetNumber {
	
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
    public static int solution(int[] numbers, int target) {
    	
    	// length of the array
    	int length = numbers.length;
    	
    	// possibilities from 0
    	int max = (int)(Math.pow(2, length) - 1);
    	
    	int count = 0;
    	
    	// check all the possibilities
    	for(int i=0; i<=max; i++) {
    		// make binary String with the number
    		StringBuilder binary = new StringBuilder(Integer.toBinaryString(i));
    		while(binary.length() < length) {
    			binary.insert(0,'0');
    		}
    		
    		// with the binary data, check the possibility
    		int number = 0;
    		for(int j=0; j<length; j++) {
    			if('1' == binary.charAt(j)) {
    				number += numbers[j];
    			}else {
    				number -= numbers[j];
    			}
    		}
    		if(number == target) 
    			count ++;
    		
    	}
    	
    	return count;
    	
    }
}
