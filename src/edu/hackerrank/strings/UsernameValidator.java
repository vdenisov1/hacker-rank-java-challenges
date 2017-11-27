package edu.hackerrank.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {
    private static final String ipRegex = "\\b(\\w+)\\s+\\1{1,}\\b";

    public static void main(String[] args){
        String[] inputs = {"Samantha10"};

        for(String input: inputs){
            if(input.matches(UsernameValidator.ipRegex)){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
        }
    }
}
