package lv2;

import java.util.Arrays;

public class H_index {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {12, 11, 10, 9, 8, 1}) +" : 5");		
		System.out.println(solution(new int[] {6, 6, 6, 6, 6, 1}) +" : 5");		
		System.out.println(solution(new int[] {4, 4, 4}) +" : 3");		
		System.out.println(solution(new int[] {4, 4, 4, 5, 0, 1, 2, 3}) +" : 4");		
		System.out.println(solution(new int[] {10, 11, 12, 13}) +" : 4");		
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}) +" : 3");		
		System.out.println(solution(new int[] {0, 0, 1, 1}) +" : 1");		
		System.out.println(solution(new int[] {0, 1}) +" : 1");		
		System.out.println(solution(new int[] {10, 9, 4, 1, 1}) +" : 3");		
		System.out.println(solution(new int[] {12,11,10,9,8,1}) +" : 5");		
		System.out.println(solution(new int[] {6,6,6,6,6,1}) +" : 5");		
		System.out.println(solution(new int[] {20,21,22,23}) +" : 4");		
		System.out.println(solution(new int[] {0, 1, 3, 5, 5, 5, 5, 5, 5, 6}) +" : 5");		
		System.out.println(solution(new int[] {0, 1, 1, 1, 1, 3, 3, 4}) +" : 1");		
	}

	static public int solution(int[] citations) {
		Arrays.sort(citations);
		final int SIZE = citations.length;
		for(int i=0; i<SIZE; i++) {
			if(citations[SIZE-1-i] <= i+1)
				return i+1;
		}
		return 0;
	}

}
