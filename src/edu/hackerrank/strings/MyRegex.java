package edu.hackerrank.strings;

import java.util.regex.Pattern;

public class MyRegex {
    private static final String ipRegex = "(^(0{3}|[1-2][0-5][0-5]|[1-2][0-4][0-9]|0{0,2}[0-9]|0?[0-9][0-9]))\\." +
            "(0{3}|[1-2][0-5][0-5]|[1-2][0-4][0-9]|0{0,2}[0-9]|0?[0-9][0-9])\\." +
            "(0{3}|[1-2][0-5][0-5]|[1-2][0-4][0-9]|0{0,2}[0-9]|0?[0-9][0-9])\\." +
            "((0{3}|[1-2][0-5][0-5]|[1-2][0-4][0-9]|0{0,2}[0-9]|0?[0-9][0-9])$)";

    public static void main(String[] args){
        String[] inputs = {"259.259.259.259",
                "266.266.266.266",
                "255.255.255.255",
                "555.555.555.555",
                "666.666.666.666",
                "249.249.249.249",
                "249.249.249.256"
                            };

        for(String input: inputs){
            System.out.println(Boolean.toString(Pattern.matches(MyRegex.ipRegex, input)));
        }
    }
}
