package edu.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MyJavaStack {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap<Character,Character> bracketMap = new HashMap<>();
        bracketMap.put('{','}');
        bracketMap.put('(',')');
        bracketMap.put('[',']');

        while(in.hasNext()){
            String input = in.next();
            Stack<Character> stack = new Stack<>();
            char[] chars = input.toCharArray();
            boolean correct = true;

            for(int i = 0; i < chars.length && correct; i++){
                if(bracketMap.containsKey(chars[i])){
                    // It is an opening bracket
                    stack.add(chars[i]);
                }else{
                    // It is a closing bracket
                    if(stack.empty()){
                        correct = false;
                    }else if(bracketMap.get(stack.lastElement()) == chars[i]){
                        stack.pop();
                    }else{
                        correct = false;
                    }
                }
            }

            System.out.println(correct && stack.empty());
        }
    }
}
