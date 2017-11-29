package edu.hackerrank.datastructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayList {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arrays = in.nextInt();
        ArrayList<ArrayList<Integer>> mtx = new ArrayList<>();

        /***
         * Load arrays
         */
        for(int i = 0; i < arrays; i++){
            int cols = in.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int k = 0; k < cols; k++) arr.add(in.nextInt());
            mtx.add(arr);
        }

        int queries = in.nextInt();

        /***
         * Run through queries.
         */
        for(int i = 0; i < queries; i++){
            int line = in.nextInt() - 1;
            int col = in.nextInt() - 1;

            if(line < mtx.size() && col < mtx.get(line).size()){
                System.out.println(mtx.get(line).get(col));
            }else{
                System.out.println("ERROR!");
            }
        }

    }
}
