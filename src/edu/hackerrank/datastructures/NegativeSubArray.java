package edu.hackerrank.datastructures;

public class NegativeSubArray {

    public static void main(String[] args){
        int[] input = {1, -2, 4, -5, 1};
        int count = 0;

        for(int i = 0; i < input.length; i++){
            for(int j = i; j < input.length; j++){
                // Calculate sum i to j elements
                int sum = 0;
                for(int k = i; k <= j; k++) sum += input[k];
                if(sum < 0) count++;
            }
        }

        System.out.println(count);
    }
}
