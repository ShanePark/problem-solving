package lv2a;

import java.util.Arrays;

/**
 * PASSED !
 */
public class T_phoneBook2 {
	
	public static void main(String[] args) {
		String[] arr = {"12","123","1235","567","88"};
		System.out.println(solution(arr));
	}
	
    public static boolean solution(String[] phone_book) {
    	Arrays.sort(phone_book);
    	int length = phone_book.length;
    	for(int i=1; i<length; i++) {
    		if(phone_book[i].startsWith(phone_book[i-1]))
    				return false;
    	}
    	return true;
    }

}
