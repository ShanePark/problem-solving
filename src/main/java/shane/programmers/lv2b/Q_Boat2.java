package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_Boat2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
		System.out.println(solution(new int[] {70, 80, 50}, 100));

	}
	
    public static int solution(int[] people, int limit) {
    	Arrays.sort(people);
    	List<Integer> list = new ArrayList<>();
    	final int length = people.length;
    	for(int i=0; i<length; i++) {
    		list.add(people[i]);
    	}
    	
        int answer = 0;
        while(list.size() > 0) {
        	int size = list.size();
        	int lastWeight = list.remove(size-1);
        	answer++;
        	while(list.size() > 0) {
        		int firstWeight = list.get(0);
        		if(lastWeight + firstWeight <= limit) {
        			lastWeight += list.remove(0);
        		}else {
        			break;
        		}
        	}
        }
        return answer;
    }

}
