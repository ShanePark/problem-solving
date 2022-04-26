package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T_Tuple {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));

	}
	
    public static int[] solution(String s) {
    	List<Tuple> list = new ArrayList<>();
    	s = s.substring(1,s.length()-2);
    	String[] arrs = s.split("},");
    	final int size = arrs.length;
    	for(int i=0; i<size; i++) {
    		String data = arrs[i].substring(1);
    		Tuple tuple = new Tuple(data);
    		list.add(tuple);
    	}
    	
    	list.sort(new Comparator<Tuple>() {
			@Override
			public int compare(Tuple o1, Tuple o2) {
				return o1.size - o2.size;
			}
		});
    	
    	Set<Integer> set = new HashSet<>();
    	int[] answer = new int[list.size()];
    	int i = 0;
    	for(Tuple tuple : list) {
    		int[] arr = tuple.arr;
    		for(int number : arr) {
    			if(set.add(number)) {
    				answer[i++] = number;
    			}
    		}
    	}
    	
        return answer;
    }

}

class Tuple{
	int[] arr;
	int size;
	Tuple(String data){
		String[] stringArr = data.split(",");
		size = stringArr.length;
		arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(stringArr[i]);
		}
	}
	
}





