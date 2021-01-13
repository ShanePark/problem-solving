package lv1;

public class SecretMap {

	public static void main(String[] args) {
		for(String str : solution(5,new int[] {9,20,28,18,11},new int[] {30,1,21,17,28}))
			System.out.println(str);
	}

	static public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			answer[i] = "";
			arr1[i] = arr1[i] | arr2[i];
			StringBuffer binaryReverse=new StringBuffer();
			for(int j=0; j<n; j++) {
				if(arr1[i]%2 == 1)
					binaryReverse.append("1");
				else binaryReverse.append("0");
				arr1[i] /= 2;
			}
			String binary=binaryReverse.reverse().toString();
			for(int j=0; j<n; j++) {
				if(binary.charAt(j) == '1')
					answer[i] += "#";
				else answer[i] += " ";
			}
		}

		return answer;
	}
}
