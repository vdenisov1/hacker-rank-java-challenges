package edu.hackerrank.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class MyBigInteger {

    public static void main(String[] args){
        MyBigInteger bigInt = new MyBigInteger();
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        bigInt.solution(a,b);
    }

    private void solution(String a, String b){
        BigInteger aInt = new BigInteger(a);
        BigInteger bInt = new BigInteger(b);

        System.out.println(aInt.add(bInt).toString());
        System.out.println(aInt.multiply(bInt).toString());
    }

}
