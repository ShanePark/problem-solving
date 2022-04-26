package shane.study.sort;

import shane.study.sort.SortController.Sorter;

public class Bubble2 implements Sorter {

	@Override
	public void sort(int[] arr) {
		for(int i=0; i<arr.length-1; i++){
			boolean flag = false;
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];       
					arr[j] = arr[j+1]; 
					arr[j+1] = temp;   
					flag = true;
				}
			}
			if(!flag)
				break;
		}

	}


}
