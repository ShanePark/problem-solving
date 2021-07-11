package lv2a;

import java.util.ArrayList;

public class P_poncketmon {

	public static void main(String[] args) {
		int[] arr = {3,1,2,3};
		System.out.println(solution(arr));

	}
	
    public static int solution(int[] nums) {
        int size = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<size; i++) {
        	int num = nums[i];
        	if(!arr.contains(num)) {
        		arr.add(num);
        	}
        }
        
        
        return arr.size() > size/2 ?  size/2 : arr.size();
    }
}

