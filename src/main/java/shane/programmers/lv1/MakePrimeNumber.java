package shane.programmers.lv1;

// +2 point
public class MakePrimeNumber {
	
	public static void main(String[] args) {
		int[] arr = {1,2,7,6,4};
		System.out.println(solution(arr));
		System.out.println(isPrime(1));
	}
	
	
    public static int solution(int[] nums) {
        int count = 0;
        int length = nums.length;
        
        for(int i=0; i<length; i++) {
        	for(int j=i+1; j<length; j++) {
        		if(j == i) continue;
        		for(int k=j+1; k<length; k++) {
        			if(k==i || k==j) continue;
        			int number = nums[i] + nums[j] + nums[k];
        			if(isPrime(number)) {
        				count++;
        			}
        		}
        	}
        }
        


        return count;
    }
    
    public static boolean isPrime(int number) {
    	if(number == 1 ) return false;
    	for(int i=2; i<number; i++) {
    		if(number % i == 0)
    			return false;
    	}
    	return true;
    }

}
