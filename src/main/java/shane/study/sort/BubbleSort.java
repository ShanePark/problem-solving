package shane.study.sort;

import shane.study.sort.SortController.Sorter;

public class BubbleSort implements Sorter {

	@Override
	public void sort(int[] arr) {
		final int size = arr.length;
		for(int i=0; i<size; i++) {
			for(int j=i; j<size; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}


}
