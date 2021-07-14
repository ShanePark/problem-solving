package shane.programmers.lv2a;

/**
 *accuracy : passed
 *efficiency : failed
 *
 */
public class T_phoneBook {
	
	public static void main(String[] args) {
		String[] arr = {"12","123","1235","567","88"};
		System.out.println(solution(arr));
	}
	
    public static boolean solution(String[] phone_book) {
    	for(String num : phone_book) {
    		for(String nums : phone_book) {
    			if(nums.startsWith(num)) {
    				if(!nums.equals(num))
    					return false;
    			}
    		}
    	}
        return true;
    }

}
