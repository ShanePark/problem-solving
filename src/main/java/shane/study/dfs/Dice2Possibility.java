package shane.study.dfs;

import java.util.Arrays;

public class Dice2Possibility {

	public static void main(String[] args) {
		play(7);
	}
	
	public static void dfs(int[] output,int depth, int n) {
		if(depth == n) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i=1; i<=6; i++) {
			output[depth] = i;
			dfs(output, depth+1, n);
		}
	}
	
	public static void play(int n) {
		int[] output = new int[n];
		dfs(output, 0, n);
	}

}
