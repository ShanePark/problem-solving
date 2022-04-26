package shane.programmers.lv2a;

import java.util.Arrays;

public class Z_CheckSocialDistance {

	public static void main(String[] args) {
		String[][] array = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] result = solution(array);
		System.out.println(Arrays.toString(result));

	}
	
    public static int[] solution(String[][] places) {
    	final int length = places.length;
        int[] answer = new int[length];
        for(int i=0; i<length; i++) {
        	answer[i] = checkDistance(places[i]);
        }
        return answer;
    }
    
    public static int checkDistance(String[] place) {
    	final int width = place[0].length();
    	final int height = place.length;
    	for(int i=0; i<height; i++) {
    		for(int j=0; j<width; j++) {
    			if(place[i].charAt(j) == 'P') {
    				// check right one
    				if(j+1 < width && place[i].charAt(j+1) == 'P') {
    					return 0;
    				}
    				
    				// check right right one
    				if(j+2 < width && place[i].charAt(j+2) == 'P' && place[i].charAt(j+1) != 'X') {
    					return 0;
    				}
    				
    				// check bottom left one
    				if(i+1 < height && 0 <= j-1 && place[i+1].charAt(j-1) == 'P' && !(place[i+1].charAt(j) == 'X' && (place[i].charAt(j-1) == 'X')) ) {
    					return 0;
    				}
    				
    				// check bottom one
    				if(i+1 < height && place[i+1].charAt(j) == 'P') {
    					return 0;
    				}
    				
    				// check bottom right one
    				if(i+1 < height && j+1 < width && place[i+1].charAt(j+1) == 'P' && !(place[i+1].charAt(j) == 'X' && (place[i].charAt(j+1) == 'X')) ) {
    					return 0;
    				}
    				
    				// check bottom bottom one
    				if(i+2 < height && place[i+2].charAt(j) == 'P' && place[i+1].charAt(j) != 'X') {
    					return 0;
    				}
    			}
    		}
    	}
    	return 1;
    }

}
