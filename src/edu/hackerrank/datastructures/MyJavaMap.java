package edu.hackerrank.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class MyJavaMap {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        Map<String,Integer> addressBook = new HashMap<>();

        for(int i = 0; i < N; i++){
            String name = scan.nextLine();
            int phone = scan.nextInt();
            scan.nextLine();
            addressBook.put(name,phone);
        }

        while(scan.hasNext()){
            String name = scan.nextLine();

            if(addressBook.containsKey(name)){
                System.out.println(name + "=" + addressBook.get(name));
            }else{
                System.out.println("Not found");
            }
        }

        scan.close();
    }
}
