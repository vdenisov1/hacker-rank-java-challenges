package edu.hackerrank.exceptions;

import java.util.Scanner;

public class MyCalculator {

    public static void main(String[] args){
        MyCalculator calc = new MyCalculator();
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()){
            int n = in.nextInt();
            int p = in.nextInt();

            try{
                System.out.println(Long.toString(calc.power(n,p)));
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }

        in.close();
    }

    public long power(int n, int p) throws Exception{
        if(n < 0 || p < 0)
            throw new Exception("n or p should not be negative.");
        if(n == 0 && p == 0)
            throw new Exception("n and p should not be zero.");
        return (long) Math.pow(n,p);
    }
}
