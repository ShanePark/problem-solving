
import java.util.Arrays;

public class HateSameNumber {

	public static void main(String[] args) {

		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++)
			arr[i] = (int)(Math.random() * 4+1) ;
//////////////////////////////UPWARD ARE AUTOMATED///////////
		
		int new_len = 1;
		int[] temp = new int[arr.length];
		for(int i=0; i<arr.length-1; i++){
			if(arr[i] != arr[i+1]){
				temp[new_len-1] = arr[i];
				new_len++;
			}
		}
		temp[new_len-1] = arr[arr.length-1];
		
		int[] answer = new int[new_len];
		for(int i=0; i<new_len; i++)
			answer[i]=temp[i];
///////////////////////////////DOWNWARD ARE FOR TESTING//////////
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));
		System.out.println(Arrays.toString(answer));

	}
}
