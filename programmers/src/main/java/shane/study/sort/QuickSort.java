package shane.study.sort;

import shane.study.sort.SortController.Sorter;

public class QuickSort implements Sorter {

	@Override
	public void sort(int[] arr) {
		lPivotSort(arr, 0, arr.length-1);
	}
	
	private static void lPivotSort(int[] arr, int low, int high) {
		
		if(low >= high) {
			return;
		}
		int pivot = partition(arr, low, high);	
		
		lPivotSort(arr, low, pivot - 1);
		lPivotSort(arr, pivot + 1, high);
	}
	
	private static int partition(int[] arr, int left, int right) {
		int low = left;
		int high = right;
		int pivot = arr[left];
		
		while(low < high) {
			while(arr[high] > pivot && low < high) {
				high--;
			}
			while(arr[low] <= pivot && low < high) {
				low++;
			}
			swap(arr, low, high);
		}
		
		swap(arr, left, low);
		return low;
	}
 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
