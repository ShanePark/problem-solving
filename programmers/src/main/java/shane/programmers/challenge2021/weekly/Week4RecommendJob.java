package shane.programmers.weekly;

import java.util.Arrays;

public class Week4RecommendJob {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}
                , new String[]{"PYTHON", "C++", "SQL"}, new int[]{7,5,5}));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String[] job = {"CONTENTS", "GAME", "HARDWARE", "PORTAL", "SI"};
        int[] score = new int[job.length];
        
        for(String str : table){
            String[] data = str.split(" ");
            int jobIndex = Arrays.binarySearch(job, data[0]);
        	for(int i=0; i<languages.length; i++) {
        		String lan = languages[i];
        		int j = find(lan, data);
        		if(j<0) continue;
        		int point = (6-j) * preference[i];
        		score[jobIndex] += point;
        	}
        }
        
        int max = score[0];
        int maxIndex = 0;
        for(int i=1; i<job.length; i++) {
        	if(max < score[i]) {
        		max = score[i];
        		maxIndex = i;
        	}
        }
        
        return job[maxIndex];
    }
    
    public static int find(String lan, String[] data) {
    	for(int i=1; i<data.length; i++) {
    		if(data[i].equals(lan)) {
    			return i;
    		}
    	}
    	return -1;
    }

}
