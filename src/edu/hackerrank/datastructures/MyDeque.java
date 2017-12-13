package edu.hackerrank.datastructures;

import java.util.*;

public class MyDeque {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addLast(num);

            if(deque.size() == m){
                Set<Integer> distinct = new HashSet<Integer>(deque);

                if(max < distinct.size())
                    max = distinct.size();

                deque.removeFirst();
            }
        }

        System.out.println(max);
    }
}
