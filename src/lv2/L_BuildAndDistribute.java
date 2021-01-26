package lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class L_BuildAndDistribute {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {93,30,55},new int[] {1,30,5})));
		System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99},new int[] {1, 1, 1, 1, 1, 1})));
	}
	
    static public int[] solution(int[] progresses, int[] speeds) {
        class Progress{
        	int todo;
        	int speed;
        	Progress(int todo,int speed){
        		this.todo = todo;
        		this.speed = speed;
        	}
        	void work() {
        		todo += speed;
        	}
        }
        
        ArrayList<Progress> list = new ArrayList<>();
        final int SIZE = progresses.length;
        for(int i=0; i< SIZE; i++) {
        	list.add(new Progress(progresses[i],speeds[i]));
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        while(list.size()>0) {
        	int count = 0;
        	for(int i=0; i<list.size(); i++) {
        		list.get(i).work();
        	}
        	while(list.size()>0 && list.get(0).todo >= 100) {
        		count++;
        		list.remove(0);
        	}
        	if(count != 0)
        		answerList.add(count);
        }
        final int LASTSIZE =answerList.size();
        int[] answer = new int[LASTSIZE];
        for(int i=0; i<LASTSIZE; i++) {
        	answer[i] = answerList.get(i);
        }
        return answer;
        
    }

}
