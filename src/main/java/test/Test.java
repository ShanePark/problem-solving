package test;

import com.tistory.shanepark.STool;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = null;
        for (Integer integer : list) {
            System.out.println("null error?");
        }
    }
    
}