package edu.hackerrank.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class MyBigDecimal {

    public static void main(String[] args){
        String[] inputs = {"-100","50","0","56.6","90","0.12",".12","02.34","000.000"};
        MyBigDecimal mbg = new MyBigDecimal();
        mbg.solve(inputs);
        for(String i: inputs){
            System.out.println(i);
        }
    }

    private void solve(String[] list){
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null || o2 == null) return 0;

                BigDecimal a = new BigDecimal(o1);
                BigDecimal b = new BigDecimal(o2);

                return a.compareTo(b);
            }
        });
    }
}
