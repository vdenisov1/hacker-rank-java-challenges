package edu.hackerrank.datastructures;

import java.util.*;

public class MyDeque {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashSet<Integer> distinct = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            distinct.add(num);

            if(deque.size() == m){
                if(max < distinct.size())
                    max = distinct.size();

                Integer removed = (Integer) deque.pop();

                if(!deque.contains(removed))
                    distinct.remove(removed);
            }
        }

        System.out.println(max);
    }
}
