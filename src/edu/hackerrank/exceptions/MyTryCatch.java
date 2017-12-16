package edu.hackerrank.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyTryCatch {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        try{
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(Integer.toString(x/y));
        }catch(InputMismatchException e){
            System.out.println(e.getClass().getName());
        }catch(ArithmeticException e){
            System.out.println(e.toString());
        }

        in.close();
    }
}
