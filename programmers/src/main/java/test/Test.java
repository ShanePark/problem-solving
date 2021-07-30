package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        process(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void process(int[] arr) {
    	arr[0]++;
    }
}