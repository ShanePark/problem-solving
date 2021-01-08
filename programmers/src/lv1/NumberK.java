package lv1;


import java.util.Arrays;

 public class NumberK {
	static int[] solutionN(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i=0; i<commands.length ; i++){
			int[] temp = new int[commands[i][1]-commands[i][0]+1];
			for(int j=0; j<commands[i][1]-commands[i][0]+1; j++){
				temp[j] = array[commands[i][0]-1+j];
			}
			Arrays.sort(temp);	
			answer[i] = temp[commands[i][2]-1];
			System.out.println(answer[i]);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solutionN(array,commands)));

	}
}
