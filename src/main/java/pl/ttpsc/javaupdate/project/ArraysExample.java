package pl.ttpsc.javaupdate.project;

import java.util.Arrays;

public class ArraysExample {

    public static void fill4 (int[] array){
        System.out.println(Arrays.toString(array));
        Arrays.fill(array,4);
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        fill4(array);

    }
}
