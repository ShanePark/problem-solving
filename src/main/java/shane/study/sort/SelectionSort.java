package shane.study.sort;

import shane.study.sort.SortController.Sorter;

public class SelectionSort implements Sorter {

	@Override
	public void sort(int[] arr) {
		for(int i=0; i<arr.length-1; i++){
			int min_index = i;
			for(int j=i+1; j<arr.length; j++){

				if(arr[j]<arr[min_index])
					min_index = j; // find min_index
			}
			int temp = arr[i];       //
			arr[i] = arr[min_index]; // swap number in min_index with number in 'i' index
			arr[min_index] = temp;   //
		}

	}


}
