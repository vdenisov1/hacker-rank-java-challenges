package edu.hackerrank.datastructures;

public class MyOneDimensionalArray {
    public static void main(String[] args){
        int[] inputs = {10,31,41,23,12,11};
        int[] a = new int[inputs.length];

        for(int i = 0; i < inputs.length; i++){
            a[i] = inputs[i];
        }

        for(int j = 0; j < a.length; j++){
            System.out.println(a[j]);
        }
    }
}
