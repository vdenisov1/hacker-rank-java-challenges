package edu.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyJavaList {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < N; i++)
            list.add(scan.nextInt());

        int Q = scan.nextInt();

        for(int i = 0; i < Q; i++){
            String command = scan.next();

            if(command.trim().matches("Insert")){
                int x = scan.nextInt();
                int y = scan.nextInt();
                list.add(x,y);
            }else{
                int x = scan.nextInt();
                list.remove(x);
            }
        }

        scan.close();

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i + 1 < list.size()) System.out.print(" ");
        }
    }
}
