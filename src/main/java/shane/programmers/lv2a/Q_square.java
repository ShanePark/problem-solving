package shane.programmers.lv2a;

import java.util.ArrayList;
import java.util.List;

public class Q_square {

	public static void main(String[] args) {
		int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		System.out.println(solution(v));

	}
	
    public static int[] solution(int[][] v) {
        int size = v.length;
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();;
        for(int i=0; i<size; i++ ) {
        	int x = v[i][0];
        	int y = v[i][1];
        	if(listX.contains(x)) {
        		listX.remove(listX.indexOf(x));
        	}else {
        		listX.add(x);
        	}
        	if(listY.contains(y)) {
        		listY.remove(listY.indexOf(y));
        	}else {
        		listY.add(y);
        	}
        }
        int x = listX.get(0);
        int y = listY.get(0);
        int[] arr = {x,y};
        return arr;

    }
}

