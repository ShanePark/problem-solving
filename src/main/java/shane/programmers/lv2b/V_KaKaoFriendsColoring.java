package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V_KaKaoFriendsColoring {

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(solution(6,4,new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
		System.out.println(Arrays.toString(solution(6,4,new int[][] {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}})));

	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		
		int[][] areaArray = new int[m][n];
		List<List<Info>> areaInfo = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int colorSelf = picture[i][j];
				if(colorSelf == 0) {
					areaArray[i][j] = -1;
					continue;
				}
				int colorLeft = j>0? picture[i][j-1] : -1 ;
				int leftArea = j>0? areaArray[i][j-1] : -1;
				int colorTop = i>0? picture[i-1][j] : -1;
				int topArea = i>0? areaArray[i-1][j] : -1;
				Info infoHere = new Info(i,j);
				if(colorSelf != colorLeft && colorSelf != colorTop) {
					areaArray[i][j] = areaInfo.size();
					List<Info> list = new ArrayList<>();
					list.add(infoHere);
					areaInfo.add(list);
				}else if(colorSelf == colorLeft && colorSelf == colorTop) {
//					System.out.println("i : " + i + ", j : " + j + ", leftArea : " + leftArea + ", topArea : " + topArea);
					if(leftArea != topArea) {
						for(int k=0; k<areaInfo.get(leftArea).size(); k++) {
							Info info = areaInfo.get(leftArea).get(k);
							areaArray[info.x][info.y] = topArea;
							areaInfo.get(topArea).add(info);
						}
						areaInfo.set(leftArea, new ArrayList<>());
					}
					areaArray[i][j] = topArea;
					areaInfo.get(topArea).add(infoHere);
				}else if(colorSelf == colorLeft){
					areaArray[i][j] = leftArea;
					areaInfo.get(leftArea).add(infoHere);
					
				}else if(colorSelf == colorTop) {
					areaArray[i][j] = topArea;
					areaInfo.get(topArea).add(infoHere);
				}
				
			}
		}
		
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        final int size = areaInfo.size();
        for(int i=0; i<size; i++) {
        	List<Info> info = areaInfo.get(i);
        	int infoSize = info.size();
        	if(infoSize > 0) {
        		numberOfArea++;
        	}
        	if(infoSize > maxSizeOfOneArea) {
        		maxSizeOfOneArea = infoSize;
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
	
	}

}

class Info{
	int x;
	int y;
	Info(int i, int j) {
		this.x = j;
		this.y = i;
	}
	@Override
	public String toString() {
		return "Info [x=" + x + ", y=" + y + "]";
	}
	
}
