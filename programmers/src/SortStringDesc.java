

import java.util.Arrays;

public class SortStringDesc {

	public static void main(String[] args) {
		System.out.println(new SSDSolution().solution("Zbcdefg"));

	}

}

class SSDSolution {
    public String solution(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array, 0, array.length);
        String str="";
        for(int i=array.length-1; i>=0; i--){
        	str += array[i];
        }
                
        return str;
        
    }
}