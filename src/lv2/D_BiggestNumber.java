package lv2;

import java.util.ArrayList;
import java.util.Comparator;
/* Review
 * 1. When answer is 0 and array is occupied by many "0", it returned something like "0000", but answer have to be "0"
 * 2. My first strategy was, comparing both numbers until their minimum length, but I had trouble in next step.
 *    so, my final strategy is just put those two numbers in each way and compare them.
 */
public class D_BiggestNumber {

	public static void main(String[] args) {

		System.out.println(solution(new int[] {0,0}));
		System.out.println(solution(new int[] {6, 30, 34, 5, 9}));
	}

	static public String solution(int[] numbers) {
		class MyComparator implements Comparator<String>{
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o2+o1)-Integer.parseInt(o1+o2);
			}
		}
		ArrayList<String> list = new ArrayList<>();
		for(int i : numbers)
			list.add(String.valueOf(i));
		list.sort(new MyComparator());
		StringBuffer sb = new StringBuffer();
		for(String str : list)
			sb.append(str);

		if(sb.toString().charAt(0) =='0')
			return "0";
		return sb.toString();
	}

}
