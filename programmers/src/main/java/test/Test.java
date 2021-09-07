package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String test="abcdc";
        char[] arr = test.toCharArray();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
           if(arr[i] == 'c')
               set.add(i);
        }

        Object[] result = set.toArray();
        System.out.println(Arrays.toString(result));

    }
    
}