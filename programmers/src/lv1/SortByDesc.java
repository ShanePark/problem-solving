package lv1;


import java.util.Arrays;

public class SortByDesc {

	public static void main(String[] args) {
		System.out.println(solution(118372));
	}
	
    static public long solution(long n) {
    	String str = n+"";
    	char[] ch = str.toCharArray();
    	Arrays.sort(ch);
    	StringBuffer sb = new StringBuffer();
    	final int SIZE = ch.length;
    	for(int i=0; i<SIZE; i++ )
    		sb.append(ch[SIZE-1-i]);

    	return Long.parseLong(sb.toString());
    }

}
